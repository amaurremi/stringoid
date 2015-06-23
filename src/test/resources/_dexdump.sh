#!/bin/bash
#
# by Erik Wittern, 2014
#
# Script goes through all .apk files and:
# - searches for any string starting with 'http://' or 'https://' and stores it to the output file
# - counts the apks it checked

#dexdump binary path
DEXDUMP=dexdump

# variable holding current folder name:
DIR=$1

# APK file to process
apk=$3

# variable to count apks:
COUNT=0

# variable for start time:
START=$(date +%s)

# variable for output file:
DATE=$(date +"%Y-%m-%d")
FOLDER=`basename $DIR`
OUTPUTFILE="$FOLDER/grepoutputs/output_dexdump.txt" #_${FOLDER}-$DATE.txt"

ME=`echo $$`
echo "$ME processing folder $FOLDER"

#for apk in `find $DIR -type f -name '*.apk'`
#do
	# print current apk:
	echo "apk-file $COUNT: $apk"

	# print current apk to output file:
	MARKER=`basename $apk .apk`
	echo "-${MARKER}" >> $OUTPUTFILE

	# use DexDump to search for URL Strings:
	# dexdump					read out classes.dex file
	#		-d					disassemble code sections
	# grep	-i					case insensitive
    #		-I					skip binary
    # 		-o					print only the matched bit (not the entire line), i.e. just the URL
    # 		-h					don't include the name of the source file
    # 		-E					use extended regular expressions
	# 		"https?://[^" ]+	that begin with ""http(s)://"
	# 							that then feature at least one arbitrary symbol
	#							until either """ or " " is found
	# cut 	-c 2-				output only from the second character on, to get rid of initial """
	$DEXDUMP -d $apk | grep -iIohE '"https?://[^" ]+' | sort | uniq | cut -c 2- >> $OUTPUTFILE

	# increase count:
	COUNT=$[$COUNT +1]
#done

# print summaryzing information:
END=$(date +%s)
DIFF=$(echo "$END - $START" | bc)
echo "==========================="
echo "Checked projects: $COUNT"
echo "Runtime: $DIFF seconds"
