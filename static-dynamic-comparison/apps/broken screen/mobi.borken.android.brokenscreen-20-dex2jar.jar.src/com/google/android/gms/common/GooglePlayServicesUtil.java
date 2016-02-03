package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.string;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hf;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.iq;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class GooglePlayServicesUtil
{
  static final byte[][] CS = { au("0\004C0\003+ \003\002\001\002\002\t\000ÂàFdJ00\r\006\t*H÷\r\001\001\004\005\0000t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\036\027\r080821231334Z\027\r360107231334Z0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000«V.\000Ø;¢\b®\no\022N)Ú\021ò«VÐXâÌ©\023\003é·TÓrö@§\033\035Ë\023\tgbNFV§wj\031=²å¿·$©\036w\030\016jG¤;3Ù`w\0301EÌß{.XftÉáV[\037LjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\025Jd_qhÀ±¿Æ\022ê¿xWi»4ªyÜ~.¢vL®\007ØÁqT×î_d¥\032D¦\002ÂI\005AWÜ\002Í_\\\016Uûï\031ûã'ð±Q\026Å o\031ÑõÄÛÂÖ¹?hÌ)yÇ\016\030«k;ÕÛU*\016;LßXûíÁº5à\003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\013\024[j¡y\002\001\003£Ù0Ö0\035\006\003U\035\016\004\026\004\024Ç}Â!\027V%Óßkãä×¥0¦\006\003U\035#\0040\024Ç}Â!\027V%Óßkãä×¥¡x¤v0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android\t\000ÂàFdJ00\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005\000\003\001\001\000mÒRÎï0,6\nªÎÏòÌ©\004»]z\026aø®F²B\004ÐÿJhÇí\032S\036ÄYZb<æ\007c±g)zzãW\022Ä\007ò\bðË\020)\022M{\020b\031ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\005»?âËD~s\020v­E³?`\tê\031Áaæ&Aª'\035ýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\013\020q§Ä@ðþ \034¶'ÊgCiÐ½/Ù\021ÿ\006Í¿,ú\020Ü\017:ãWbHÇïÆLqD\027B÷\005ÉÞW:õ[9\r×ý¹A1]_u0\021&ÿb\024\020Ài0"), au("0\004¨0\003 \003\002\001\002\002\t\000Õ¸l}ÓNõ0\r\006\t*H÷\r\001\001\004\005\00001\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r080415233656Z\027\r350901233656Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000ÖÎ.\b\n¿â1MÑ³ÏÓ\030\\´=3ú\ftá½¶ÑÛ\023ö,\\9ßVøF=e¾ÀóÊBk\007Å¨íZ9ÁgçkÉ¹'K\013\"\000\031©)\025årÅm*0\033£oÅü\021:ÖËt5¡m#«}úîáeäß\037\n½§\nQlN\005\021Ê|\fU\027[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\006¸Ì\030^±Uyîøm\b\013\035aÀù¯±ÂëÑ\007êE«Ûh£Ç^TÇlSÔ\013\022\035ç»Ó\016b\f\030áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\032¾^òÑ\030á¸®ó)ðf¿láD¬èm\034\033\017\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024\034Å¾LC<a:\025°L¼\003òOà²0É\006\003U\035#\004Á0¾\024\034Å¾LC<a:\025°L¼\003òOà²¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t\000Õ¸l}ÓNõ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005\000\003\001\001\000\031Ó\fñ\005ûx?L\r}Ò##=@zÏÎ\000\b\035[×ÆéÖí k\016\021 \006Al¢D\023ÒkJ àõ$ÊÒ»\\nL¡\001j\025n¡ì]ÉZ^:\001\0006ôHÕ\020¿.\036ag:;åm¯\013w±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\0319u3¯Øª\026\017BÂÐ\026>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\022þû¤Ä#ûOøÌIL\002ðõ\005\026\022ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\0035iÞ;¿ÿ|©Ú>\022Cö\013") };
  static final byte[][] CT = { au("0\002R0\001»\002\004I4~0\r\006\t*H÷\r\001\001\004\005\0000p1\0130\t\006\003U\004\006\023\002US1\0130\t\006\003U\004\b\023\002CA1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google, Inc1\0240\022\006\003U\004\013\023\013Google, Inc1\0200\016\006\003U\004\003\023\007Unknown0\036\027\r081202020758Z\027\r360419020758Z0p1\0130\t\006\003U\004\006\023\002US1\0130\t\006\003U\004\b\023\002CA1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google, Inc1\0240\022\006\003U\004\013\023\013Google, Inc1\0200\016\006\003U\004\003\023\007Unknown00\r\006\t*H÷\r\001\001\001\005\000\003\0000\002\000H\003\031ù±G&8N\004SÑ\013¿Ç{%\004¤± |LlDº¼\000­Æa\017¦¶«-¨\0163òîñk&£ö¸[úÊû¾³ôÉO~\"§àë§\\í=Ò)úseô\025\026AZ©Áa}ÕÎ\031ºè »Øü\027©´½&@Q!ªÛwÞ´\000\0238\024\030.Å\"üX\r\002\003\001\000\0010\r\006\t*H÷\r\001\001\004\005\000\003\000@fÖ1ÚCÝÐaÒ&às¹Ä¹øµä¾<¾P\036ß\034o©YÀÎ`\\OÒ¬m\034ÎÞ Glº±èò :ÿw\027­e-Ì\007\bÑ!m¨DWY&IàéÓÄ»Lõ¡±ÔüA¼¹XOdæ_A\r\005)ý[h\024\035\nÑÛ\021Ë*\r÷ê\f±-³¤"), au("0\004¨0\003 \003\002\001\002\002\t\000~OòÖµÞ0\r\006\t*H÷\r\001\001\005\005\00001\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r100120010135Z\027\r370607010135Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000Ø(q|6Ñ\027\017ÔM\n{\017\007\021&è[¿ß3°4`\000ZÌûe¥Û ²Cß`±¿\006ß\035\\\n3âÑcõ\023ß\035\"SAê<3y\"è\\\002ì4ÎÙL¸\007#¦#ÿK¯û´åïæw;>¢¾¸¼²\002gÏçQ\037.ù«uþ\036)Ï¼M\b:\037\022R\000wsò\026[i{\000£ Á:Ì0ò!cÁn=J²\0246LEÀC\0242p9ñÚ\t`ñ³ü\030¶V\020Æ\"_Ç\020+|o\023¤]$ãàÅNgã[g\b'\023ÒÖðWÝ4WÑÄþÝì:O?#\005\031§\n(64¬5£J½¡}Z\n\tûø\006\013\003j'x`cú\f7¹çò¡\016v¼w\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024µÇù\022ox\r:ûÊess?õ\"k\02770É\006\003U\035#\004Á0¾\024µÇù\022ox\r:ûÊess?õ\"k\0277¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t\000~OòÖµÞ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000L>§e}&æ»×\021\f\031ß\037¡\t}3\017iÞ¿ÊÛF£~å³\017»4{\034uU¼»<T\024F_y*\002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\006.@nÎ\030\006\f`Iü6'\021qåoË¡Ræ\005ÎÎY\037Äô©+3ºØ\031mwoU·Ð\032Ï1Ý×\fì·xv\006e\020ùI¥RJ11³ËeAÏ5B\016¼ÄR%Y?Bfi\005rfbO³ÏÛR\027\035\021\034n\003F\026øQ!\030Ð¢¦\023×ðÍ\021ÛÕ#ZT¥JÂQçÒ,Dj?î\024\022\020éDGK@c\007»&+OkÓU\034sQÿ¢`[\005â$×\025Øzö") };
  static final byte[][] CU = { au("0\002§0\002e \003\002\001\002\002\004P\005|B0\013\006\007*HÎ8\004\003\005\000071\0130\t\006\003U\004\006\023\002US1\0200\016\006\003U\004\n\023\007Android1\0260\024\006\003U\004\003\023\rAndroid Debug0\036\027\r120717145250Z\027\r220715145250Z071\0130\t\006\003U\004\006\023\002US1\0200\016\006\003U\004\n\023\007Android1\0260\024\006\003U\004\003\023\rAndroid Debug0\001·0\001,\006\007*HÎ8\004\0010\001\037\002\000ýS\035u\022)RßJ.ìäçö\021·R<ïD\000Ã\036?¶Q&iE]@\"QûY=Xú¿Åõº0öËUl×;\0354oòf`·kP¥¤è\004{\020\"ÂO»©×þ·Æ\033ø;WçÆ¨¦\025\017\004ûöÓÅ\036Ã\0025T\023Z\0262öuó®+a×*ïò\"\003\031ÑH\001Ç\002\025\000`P\025#\013Ì²¹¢ë\013ðX\034õ\002\000÷á Ö=ÞË¼«\\6¸W¹y¯»ú:êùWL\013=\007gQYWºÔYOæq\007\020´I\026q#èL(\026\023·Ï\t2È¦á<\026zT|(à£®\036+³¦un£\013ú!5bñûbz\001$;Ì¤ñ¾¨Q¨ßáZå\006f^{U%d\001L;þÏI*\003\000\002jÑ\033×ÕfÒzô9À.Ah¬ýE´¾¼{\034wTi?\rB¤üá\0208BO¦Ñ0RNïöñ78c/¦7)þMF ¸feîðA\0279\001\003[\034j£\030\030\r0:¨ÌY#àjo«úuh<E;²\007w|òýçÏ±\02408\024ª\035÷´=[\"+W\006´0\013\006\007*HÎ8\004\003\005\000\003/\0000,\002\024\tÒÑ°G\002)µ¾Ò&aÑ\022òpÅæ\035\002\024gP\002\006§Pºx®Ç\027O\026\004ê¢÷") };
  static final byte[][] CV = { au("0\004L0\0034 \003\002\001\002\002\t\000¨Í\027É=¥Ù0\r\006\t*H÷\r\001\001\005\005\0000w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\036\027\r110324010653Z\027\r380809010653Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000Ã\017­Ù´\tj,XjZ5kú\002iXøÿ\f]úõI&ØpÞè!¥>\037[\027\017ÉbE£É§ËE'\005;ã^4óÒK\"ì\fRn&teàhuêb\037ù@ã4[ I\007ÌTt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/àb\037\0375¨$%,o¦¶3§hk>Ha-\006©ÏoI¿ñ\035](þ\024¬WbCÝ)êý¹\rã&5\023©\005¬¯ ~Fu\nZ·¿w&/G°?Z<nm{Q4?iÇ÷%÷\013Ì\033JÕ%\013pZæè>â®7þW\001¼½²oîýÿö\017j[ßµ¶G\002\001\003£Ü0Ù0\035\006\003U\035\016\004\026\004\024\034ÎÎ\016êMÁ\022\037ÇQ_\r\n\fràÉm0©\006\003U\035#\004¡0\024\034ÎÎ\016êMÁ\022\037ÇQ_\r\n\fràÉm¡{¤y0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC\t\000¨Í\027É=¥Ù0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000¤pÇ(áÓ\033\006Ù¯jçhµe\004lWkCrI1×]L¡\f2\025 Ó<Ïí*¦Tb#Lù¶ù\020ÌgkËÖÀgcWO»x3\022uÜ\\óº©\030×\005\037û¢­èó\003ÍèÙæ\004\037Û|*I²\"ÆÿB+ñUi¸^îí°J£\bsÛæKtøòÂöÄ\001$ª¨Ñx\r\030Q+T\nÝ(³éX\031q¤\027\rØhÏ_1äG\022²Â;µ\0207×ï¦å½³^,ëk°\"cl\027¥j¼zP%\013Òí{1UZ\030E.\0272\032\rRö?t-tÿyXj\\»¯q¨KÏtC\020éé'Y\000¢=Ð\006`\f\"8Ù\013/³rßÛºu½."), au("0\004L0\0034 \003\002\001\002\002\t\000Þv\004\035vPÀ0\r\006\t*H÷\r\001\001\005\005\0000w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\036\027\r110324010324Z\027\r380809010324Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000æÿ=ïé*¡\rqë\017¦@À6·âCîíh¦¤v=Ç¥*1u|ÚÆ\037å\020»sÇ\026ä\000\001\004&[4ÎÎôÄ+ñá7Ð¨vð(\"»Áù½Õ×\023²ö©5£yÒË©ÉoÒÐx|\021ñë\031T\b¦ r³Klú\ná'gé\000u0\026i¡\034ïFÎ÷Ç\004mÞ1û`(M\022\n°çÞ\035c?\007h}FQ\023ÿýÆ¼ |©\004¸¾\035 ª{NuoC`d¾\\®<hè»yBÍõ\026\007É0¢üÚe[uÐuº­\006ç9½\013¢\037@BÂÀ¨ZZ°ÐgÆÃìI! B¬c§å;Tle´`´ãæâ>\037wÏçöÞtK\032e\002\001\003£Ü0Ù0\035\006\003U\035\016\004\026\004\024¢èd°]\b\\4Û\n\000P\021zì0©\006\003U\035#\004¡0\024¢èd°]\b\\4Û\n\000P\021zì¡{¤y0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC\t\000Þv\004\035vPÀ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\0007q\fè|<Rê0ÆébÙKM_\022Â]&\025AýµU]\022Îó¸1,?]ö¨ªàL¹³\005ä'ý\035-\031áÒxñ<R\017\030!\002cØÔ½6QHØØº&Ø¹¿\tõý>»\016£ÂðÉ7o\036\037Êvó¦¤\005B\b\033u*z·Vé«DÚA«ÈáèøÂu§CûsæPqW\fËkzÝ!¹ÆäVá,\"=\\\007JßUö«Ú&-dê\nEîÍ´\022~uÇSÃÿ0ËÆxµ\034R\024rñ}¢\n\rÆ'J¢F44Á©¶\024ßi}õÊ\001ç¢\\}³û\005]eV\004°\0358«ºW³¡p>ÂçJÓ4") };
  static final byte[][] CW = { au("0\005a0\003K\002\006\001DÓ0\013\006\t*H÷\r\001\001\0050v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0220\020\006\003U\004\003\023\tClockWork0\036\027\r140307220225Z\027\r380119031407Z0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0220\020\006\003U\004\003\023\tClockWork0\002\"0\r\006\t*H÷\r\001\001\001\005\000\003\002\017\0000\002\n\002\002\001\000º<9\013þYb¼ü<Æ'Z\025íÜÝ7:Uj\013âýC÷\030³\001Ò@'ãr\tÎýâ|&° Þ6}\032ßãN§®7óõà&rzN\b(;ïvøöC¼\025'6 H?É·«R<ó½{f-*'L\000Øç\021è°&_í©uÜÈåB\023jbq.\013/9yQÛ$±W¡¿çÅkÎJ8\013%ú¹&c>¨\0048à¶\013¹~.ú\005<2)Ùao¤½!{7C\037ÍØí!§òðFà\034¼ZbãJ\025káZ\027ÿ\002\027dDÖ\023±\036×_\030î´ýäZã\034ä¯¤68¶,\\ÒÛ\n\001Ä2a(äÅ\031z¾¬ÌmÂè­¤B_\017Õ¥¥X$a¿x\021á.Î\016ê\006\003?T9íàqÿÄl òß¾##:dÁÎ\t­¡ËÎkö¼¢.JÀÉjluOì\030qØ{\020Á Þ`¼}wÞ0ÕN¸GÎk\022|\031\036§o\nFÁFó6¹4êºZ_\034\003d·RUD2Pýcªå{ë«à&?\t\bM\031D\006\f:Ù»ºyôÞ<+-7º³\rK¹\021ÜQià¯RôÓ=³òË\034R\002Rpa¿\001°BÐ~ä\021©ª 'ðDÚ(ÅÝØSW§\0369»Q³Wëor\030üÌ\027\030¦0gF1àU9\032zgòZ b\001Ö\"¸Ð\tÝ\021Õ\006¢\003\017$'®gØ\03347yy\002\003\001\000\0010\013\006\t*H÷\r\001\001\005\003\002\001\000¤Ä4aÈ5¥±\nÍ\001$7jÚ'C¬0\003Hg\013 +­ã?/º*\007d\003µ\013èqÊ*²¾½»Ä\006Û\t9AÉ\027j\016Fÿÿ\000\026\026\004DnÜá0þ\020\036ã\005·~=©¢­4©Ò´Ú\033&ýZ[p\034Õlþédzä\024;¦|\002e±\024ò2¥ï\027ád¡I\027\0340½Z6«øóBÈã¯¼oICs\007}j\021×9\"\rZ×µ\031/\034þJr±¸Tuàé¾hrfe±+ôîÃ\"VTõáò+ëU¾fwÖ_\t-ù^þï\017ÇêÊ]\016¾\035A\004\037ç Ë20~9.\023ñ 9Ti0\002\027@-öÇ rçß8ºÃ×\"5oæTj|WßgÉ=+5T5ðù¡\023Î-ìÍm¡ÃKAì®Ö ëR0%Åà\004ì´Q¼EáHZÌ6¶I¯YLU\033\013É8ËÖ\032ÕgY ÷:eá©È¤Û¬\036ë\f)\t^ÞA\005{<®êN\026Å¹EKâY\021´¢\037?z¿Àgô\030.A¤ä4ð/í¯WrJU3WÚ_³ÍüùTÿØÉQwçu\004¦B¾\\Û á\000eü|h\022í'³¨\004×¤ÍÙ\fÓìË\005¨È`ÐV N´\036\005ý9\\\037§{³\035¥$4^\n½N\001µ\006OêºBÓ-Ôg>ÏÀ\027\035&éÍ\\FïÐ"), au("0\003¿0\002§ \003\002\001\002\002\t\000ÚÃÙ\025sÓï0\r\006\t*H÷\r\001\001\005\005\0000v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0220\020\006\003U\004\003\f\tClockWork0\036\027\r140307220118Z\027\r410723220118Z0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0220\020\006\003U\004\003\f\tClockWork0\001\"0\r\006\t*H÷\r\001\001\001\005\000\003\001\017\0000\001\n\002\001\001\000Ü\035oK(í80\024²öÚÿÓ\035Þ{\036c\b@e\013X±e£j®¶,qS.\004E\t¯\037ºO\030dÃ§µÖSÌ\000\025\000\020áåfú7ªÿ\0306]®{JÝ±óÌGp¢>bþµrÁi1Z¯Nôê¥®\037ÍÖçåêÔ1\023tFF\f|(û2,\\\\z¨wÃp?à·~¶ n¬krê ­!\n°*\037ÜüvbttA©?<ê\026ô\"Áã2A2~ÂÉ÷01.\033ïî)\013E\0324,¬ï[\024rÖÙ~ùT(ÌÕï\004¸Äñõ\rÒBÕ]rXfP[^K\033\036Y­\035/ H\025g;ÆæC)ìÄêÔÛd©k1ÛÉ\007\002\003\001\000\001£P0N0\035\006\003U\035\016\004\026\004\024G\020¤<³êø?«!b \000Î,z0\037\006\003U\035#\004\0300\026\024G\020¤<³êø?«!b \000Î,z0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000\0079b\013¢}*\017TC­\033`\034)Ù\001(êü?Ö(__bj>ðWæî²¬\\¢æ\005Ê=3õk\0002ÄGæP\017%½\027Êù\0039@ÈîlÜµ;íä±òHçÐ çÊê¥2ÏÚþJ¥í@@ND÷[ïÒÊÛ5¸²\033xF^\027\"òzû+\013n\025DÄ«\fOe{\031×}SÉÏ¹î-OE¶Tà\022¼éäÂâÃÓQ\003Ø®M,ÁÈbxW®u?\035{\002£§\005xÆ\005ã\005\034l\035©I\032Î\023»Ð}}Ô&Q®¤G5\rë@^ò«óf®/ÊXÒö¿\035¿K\034Hà \001TßÏ\002%\022õ¡Ç\"s\035ãðGÖø") };
  static final byte[][] CX = { au("0\003m0\002W\002\006\001=døÖ³0\013\006\t*H÷\r\001\001\0050|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0250\023\006\003U\004\n\023\fGoogle, Inc.1\0200\016\006\003U\004\013\023\007GoogleX1\0270\025\006\003U\004\003\023\016Glass Platform0\036\027\r130313181742Z\027\r380119031407Z0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0250\023\006\003U\004\n\023\fGoogle, Inc.1\0200\016\006\003U\004\013\023\007GoogleX1\0270\025\006\003U\004\003\023\016Glass Platform0\001\"0\r\006\t*H÷\r\001\001\001\005\000\003\001\017\0000\001\n\002\001\001\000¡3¦Òi¯Ø6ã®Ü-¤­9¿øâ\031æH3´\030µ=5lì\024¸GF´\013ß\036B¡þôÑõ×B\fÀØ+çÚe\tÄ¯?ÛÎ/PTïìçA©éRZ\023#\003ÿÎ\025D¦9»ÊØt¯ ¼¼õ\026öYÚ7Á­/è£ÄZæ\036Ê¨W¢\005C9í¿oð@nÂA½\buqc).s©)\004ù=ìk½@c¼¥>y¸©Cp|¹üA;X\0170ðGE´õ7­§æ\032ÿüw\013NÓ<><ttb\036z­Ôw­\005ÜuL\r3\rÁXõæáõ¢`<Q&¬Bô\030Û xF)à\r§ë\0065ÙºGµE\fZ¢dØ/\002\003\001\000\0010\013\006\t*H÷\r\001\001\005\003\001\001\000è\025JôØôu°ã[ðÒR\006c\bLÏÑr%éKþÁJ\037¾7ErpÀÿVöVÁPéË¹Ùl\034;\013¡æ<êõÔæ«C*Ü±\023Wòc´èÍ®Ð¼p}ó\026í.©¶VxÔMþíä/°#¯cc±NSÄB²+ø«À¿i\005÷ó[(\022Kæc\035F\f9_5éu«FÞ\f?ß0Ï\017\007ÙE­}Ç¨d;ICà.&[\020tÕùKùXìÚúªoÅ¾¨Ìfý!»²nÏeéø.µ{gìÁéx·Ú'\027æÖ\035ç¦l!¿ÂY¶ÞÉ½zµòÓÛÅ\023\005ÚÚ¨ïâ)<¢\027:ì#\b`pNwÉÀ¦b0§"), au("0\003É0\002± \003\002\001\002\002\t\000Ãi ­ßtÇ0\r\006\t*H÷\r\001\001\005\005\0000|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0250\023\006\003U\004\n\f\fGoogle, Inc.1\0200\016\006\003U\004\013\f\007GoogleX1\0270\025\006\003U\004\003\f\016Glass Platform0\036\027\r130226205628Z\027\r400714205628Z0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0250\023\006\003U\004\n\f\fGoogle, Inc.1\0200\016\006\003U\004\013\f\007GoogleX1\0270\025\006\003U\004\003\f\016Glass Platform0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000¯ÊGêäÐ;\036\bà\tw¢ø\006Æ¢\027\035í§[pâ:¢ñ¹¿h¥/?v,¾Æ:\bÑBZÃ\033é2m\001\036|\006Î¡ÈJëp?Ð9*1\006²}\004^|áT\004K\"Ê¥\035[õù±$â\"ºsA-ÔY0h,Fg1°Y¯¦¤èÝ?^µ@øº\021](G@)×\0371å»°ê^0 äuµ¤ý4\027\nÔ.ØPë9T,+éµm5þ¶²¨4iúKæ+È¤|è\000\003l®ðõ3sÉX\025¸ÊÙs[¿·\000eh¾mæw\020-E¿¶9z:\037\001%¸\025\005\005·«ÝÂ`\037~ñXÕ(á­;pmhE\017%:\023íyÀ\002l¨\023\021ÕËß·\002\001\003£P0N0\035\006\003U\035\016\004\026\004\024óSB\037\017Í{#j_µ\037fWc\031Ð{0\037\006\003U\035#\004\0300\026\024óSB\037\017Í{#j_µ\037fWc\031Ð{0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000©X±/\007ï\024}CÅ=ÂÉèá\001¥b\bfF¼\004·\035÷yxÜ!/ü|\003ú¯Y%;èõ2Â_]uºæïº´XRp(hk\001B'¥A·C§³/4Ñ[Yô \025X%ý¼ì>ÒtÎìÇ\001Ë«[Ug\"3wn÷ä´â\001R\016FÕEI\\\024Ày­}\037ýã¢±Ê\033Q[ +7[÷/6\017ó-­`S:Ú×Å~#dRE¥ºÊÊBTý!³d!_\004vòéI\031÷W \023Xv\nF!î\003UÙ»@h\017Úó±¨f\004+Ë@3àw,Öãª\036 Æñ\002\004úå[£áÙßëÔ@Uü\007¨æ­;Ô\0217ö/_f£÷\030$õO({Úø?") };
  static final byte[][] CY = { au("0\003Á0\002© \003\002\001\002\002\t\000é\005DY+P0\r\006\t*H÷\r\001\001\005\005\0000w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\036\027\r140527043400Z\027\r411012043400Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\001\"0\r\006\t*H÷\r\001\001\001\005\000\003\001\017\0000\001\n\002\001\001\000Ðuk\027*HI*Õî>r~ë`\"¬Ø\b»W\fECÚCÄaåçb\034\005\n]ç¢½\017\f\002`ÿâr]ØHH$\032\006îf¬+ýáÞ\r\tEWËÇ\"ne¿)\035\017å-¨ÑRg7ìj\016.7ù³ÎÓÓÙå°\tªYÛ!VÈÊ#u´\034fö9\n-\016\016IÁxt\tÀÙ%_ËÅY\022\033Oòâ-±ât\032\000ÚIYôan­\016\022mÀKeðï\017¼BzÔ2ÏOïM:d`ÊÄ÷rXê-è½@¿\007ó?`]}Wf¾z!òJ',ªX¥9\\Íÿ&}\013Ôò~D-É¼ÄJ\024dW§:J½!_w\002\003\001\000\001£P0N0\035\006\003U\035\016\004\026\004\024³ÌD*Ûè6xð[4q4¬c\036` 0\037\006\003U\035#\004\0300\026\024³ÌD*Ûè6xð[4q4¬c\036` 0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000+ù\033qéèî\002[Ué<â¨R\027%¡ª\031\020Bï­6¸) É\033'\037ãûiD3\023gú¦&¤â(\035ì¥ßÌÝ\003ÆBªñ{tÜ&ü^P½OLââ\033kûìë\033ÝpåÿÈ[þ²A\031D'3ôÐÚMc<^¾å\n\037\024?E£ÏÎ@®ÐaÕ+\007¹b¼fÑ_>ÔùÖÆH²\0218ÊúþvôÜ»å\"¢l.Õ\b¦·\táW*P¯SÑ\006:\0271½\027i[GÙ¡4!g.\fp\034ÊÎ¶\026g5.IaÁ\f×JD6y+6N5³\020 _+\024²hsbK7èi:\034´í3oVáØ zé\002³>9\016Q²Ê4@\""), au("0\003Á0\002© \003\002\001\002\002\t\000ÐTãÎÛÎ\0040\r\006\t*H÷\r\001\001\005\005\0000w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\036\027\r140603192622Z\027\r411019192622Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\001\"0\r\006\t*H÷\r\001\001\001\005\000\003\001\017\0000\001\n\002\001\001\000µ\037{°ìÎp4cÎÓ\0354r¬¶©£õ?ßÐæ#ð={4]\037õ\"Øízeå3´â>ñ@k}Õ\024h\035>vÎÐe\005óM#\021_\000WG6I-hÏ|¶Ø|§uÂeÞ!\037­pg\bø¯1,í3.Çgb\bà/{í{4f¡2\005tu²gm¸q\034và;Ì7¤c\005(#ä_*rN8'\020&\007oTÂéÈ¹ÿ#Az/Èµ s®\t_\036«ÜJÎzó%\003s\003d\022Ôñó,(Lâ¾ý_öèÃ\021äÎ\033TgHûý¡ãß0¦ø,ä¥ËÕ*?ò\025s:°ÈKz\030ïQlÐá¯°\017\b­\037\006ÿ2é;©\002\003\001\000\001£P0N0\035\006\003U\035\016\004\026\004\024§L:À:o°\núúÉ×@(\\ «\0200\037\006\003U\035#\004\0300\026\024§L:À:o°\núúÉ×@(\\ «\0200\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000 >dBCQ¼>Y_Ôà¥\n=-à\"s7\000KÌ;7|yê²¬\031íÎ]$<W2¤sóPh9\000þÖd\006Î\bÈ\023&Ò\023ÔûÃ%ßkøê»¹\033<.a°ÚtFS`sj\037H-Ét;â÷a\024\030èCY]\032\032¶¡-ÐvÆ}L#ª\017×°ñ\bã;÷\037En·RÃº\007öÐ{¤Wß\001t²\b§¡^ÉD#n[ÔØ7\001Ý_\f  r8bø\002aÈ4r9¤\013Í\020\017\f(âÏ*~º#%o_¬$f#\017§Ï}ÆâDD\020\017Ý¾)Áí|G\0200ïV\006ý\005Ç`\027¥¯ð2Sh¯\001£ ÷\017O\r\000+E\026¨4ÚÌ\tÍq6") };
  static final byte[][] CZ = { au("0\003µ0\002 \003\002\001\002\002\t\000å×\027Ît¡0\r\006\t*H÷\r\001\001\005\005\0000q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\036\027\r140529162639Z\027\r411014162639Z0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\001\"0\r\006\t*H÷\r\001\001\001\005\000\003\001\017\0000\001\n\002\001\001\000¾¡ÀW\037¸\f]xw#T\021;\003b\032ÖrV&-.-hI°\021ÑùK7ký\027üÞ7¤ÿ\021+*?/Rn\013ïæÅÌÃBátÑ2Ã$_{ó\030U'ï²-µ\016¿yËò3ÝÚ1K\004»Íò|è/75ì$e\\Ô+/5®JRÍ¢îtÒ+ÛR\023SègZÉ¸ýR®\031ªªo^ë_Ùºs³b &©hÔÂnW'f\017p®A\031/v;=pUV1*ý\037\n`Öþ\021úR¦\022: Î3A$ýÆ\n~*z6yÛ£=ø\"´\007mÊº»«ÎÛ\034&Ë\001ëÏÂ\023fð\0330\016µHÊñ\005xÆ\r:kihR\\x<\003Ý\002\003\001\000\001£P0N0\035\006\003U\035\016\004\026\004\024Â¸ç\001Að\nà\013\\\006?Mnú\007p¦0\037\006\003U\035#\004\0300\026\024Â¸ç\001Að\nà\013\\\006?Mnú\007p¦0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000H¡LÏsf¦\005óS\003,P\020$Ze%\020Å)@ìÛ¾_Ü} Ý4­Ò\033ÏVðÂ-Ã9þI\023:ûÐÂ!£í_rEå!9¼\022VwòI2í34·|«­\025F\022tN¼\030Ý&Cóc#UHÌ^Á?JqxP?c÷\0176C@ùc7]ÈÉ=úzO'ÂØZîý¬¢¹Ï\013q¤\rrþAÌ\004d¯,1\bì|\006Uõ«Ò«¢UáÍY\"³v·Kº\033\005[Ç×¶ó' §Òõ ¼\003çµn+Û'¦ð)qG\025$ éÑDÀþåÎ¢)ß\b-ù\0207p\000uî<èÀÎ\\\003¹5Óý\025v\005Fl"), au("0\003µ0\002 \003\002\001\002\002\t\000åo\t\033\0370\r\006\t*H÷\r\001\001\005\005\0000q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\036\027\r140529162612Z\027\r411014162612Z0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\001\"0\r\006\t*H÷\r\001\001\001\005\000\003\001\017\0000\001\n\002\001\001\000Ä_Uº4\\Ñ@_IÚÏ96Ör\017Ë6áMÚÿ\000ß[rÂÑN­ÌdÑþÈ/ðLÂ®Öæ¤ÑKc\037ØÖ\030]à\020A\024\036w\tUñq­«*­ÉV94O+úzQ×ëÜ.Îñh~¶\036\001ÀñI?\003Tj\032­­$\\÷22ZÿZ·À\033\t\001a~\022\036\025»Æ{(WiËZ6+6¦2s§\001y ë@QÅ¦@ùvTOo\025Á»À\\®r&.t#2¡ßK°ð;àU·6TÛ?óú)°ÔÍZË=§Äø~jü\033Yy\t·\025Å\"eÖÃh,æ\025E­ê)å­ÎçWà¯\002õx\r©\030Z9\030-#G\002\003\001\000\001£P0N0\035\006\003U\035\016\004\026\004\024à»øÁWûã»ùfÉä;¤Ü\004'\nõH0\037\006\003U\035#\004\0300\026\024à»øÁWûã»ùfÉä;¤Ü\004'\nõH0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005\000\003\001\001\000îÅô/jêâ6\035ðÇÕ\bQér\026eàF\000ÅøÌ×^64Ì õÅÓ2»gÖà­\025k\003oímÒ[\036h¿7åiå[vN\f\031\027¾\035Ï¿|\t\016Q¿¯\006\004¬\031Ï×@åøväj'½ü¾¦·®\036 Up\035\"0\005ì ½Àþz\021a¤Û}Ñ\027ë\024th¾Ø(¬JbåîW·5Â\022¿ò^tòIJ\nZÖ8Y½\feóÍÒDN±*\024Å¸\n*Ý×{\006ÓqÌ·Î¢«S:\037z[(S4é\020 ó²EÜkÊ¦Ä,Ë(;ìá/1Û\024t%KPIÙ\027yÍ#}ò¦*b£\bÜ?Ñ7$gÍ`q") };
  private static final byte[][] Da = a(new byte[][][] { CS, CT, CU, CV, CW, CX, CY, CZ });
  private static final byte[][] Db = { CS[0], CT[0], CV[0], CW[0], CX[0], CY[0], CZ[0] };
  public static boolean Dc = false;
  public static boolean Dd = false;
  private static int De = -1;
  private static final Object Df = new Object();
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 5077000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  public static Intent Z(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return hf.aD("com.google.android.gms");
    case 3: 
      return hf.aB("com.google.android.gms");
    }
    return hf.fv();
  }
  
  private static Dialog a(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (iq.ga())
    {
      localObject1 = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, (TypedValue)localObject1, true);
      if (!"Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(((TypedValue)localObject1).resourceId))) {}
    }
    for (Object localObject1 = new AlertDialog.Builder(paramActivity, 5);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new AlertDialog.Builder(paramActivity);
      }
      ((AlertDialog.Builder)localObject2).setMessage(d(paramActivity, paramInt1));
      if (paramOnCancelListener != null) {
        ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
      }
      paramOnCancelListener = c(paramActivity, paramInt1);
      if (paramFragment == null) {}
      for (paramFragment = new ha(paramActivity, paramOnCancelListener, paramInt2);; paramFragment = new ha(paramFragment, paramOnCancelListener, paramInt2))
      {
        paramActivity = e(paramActivity, paramInt1);
        if (paramActivity != null) {
          ((AlertDialog.Builder)localObject2).setPositiveButton(paramActivity, paramFragment);
        }
        switch (paramInt1)
        {
        default: 
          Log.e("GooglePlayServicesUtil", "Unexpected error code " + paramInt1);
          return ((AlertDialog.Builder)localObject2).create();
        }
      }
      return null;
      return ((AlertDialog.Builder)localObject2).create();
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_install_title).create();
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_enable_title).create();
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_update_title).create();
      Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_unsupported_title).create();
      Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_network_error_title).create();
      Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
      return ((AlertDialog.Builder)localObject2).create();
      Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
      return ((AlertDialog.Builder)localObject2).create();
      Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_invalid_account_title).create();
      Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
      return ((AlertDialog.Builder)localObject2).create();
      Log.e("GooglePlayServicesUtil", "The date of the device is not valid.");
      return ((AlertDialog.Builder)localObject2).setTitle(R.string.common_google_play_services_unsupported_title).create();
    }
  }
  
  public static boolean a(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramPackageInfo == null) {}
    do
    {
      do
      {
        return bool2;
        if (c(paramPackageManager))
        {
          if (a(paramPackageInfo, Da) != null) {}
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
        }
        bool1 = bool3;
        if (a(paramPackageInfo, Db) != null) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (bool1);
      bool2 = bool1;
    } while (a(paramPackageInfo, Da) == null);
    Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
    return bool1;
  }
  
  public static boolean a(Resources paramResources)
  {
    if (paramResources == null) {}
    for (;;)
    {
      return false;
      if ((paramResources.getConfiguration().screenLayout & 0xF) > 3) {}
      for (int i = 1; ((iq.fX()) && (i != 0)) || (b(paramResources)); i = 0) {
        return true;
      }
    }
  }
  
  private static byte[] a(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    Object localObject;
    try
    {
      localObject = CertificateFactory.getInstance("X509");
      if (paramPackageInfo.signatures.length != 1)
      {
        Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
        return null;
      }
    }
    catch (CertificateException paramPackageInfo)
    {
      Log.w("GooglePlayServicesUtil", "Could not get certificate instance.");
      return null;
    }
    paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramPackageInfo);
    label131:
    for (;;)
    {
      try
      {
        localObject = (X509Certificate)((CertificateFactory)localObject).generateCertificate(localByteArrayInputStream);
        int i;
        i += 1;
      }
      catch (CertificateException paramPackageInfo)
      {
        try
        {
          ((X509Certificate)localObject).checkValidity();
          i = 0;
          if (i >= paramVarArgs.length) {
            break;
          }
          localObject = paramVarArgs[i];
          if (!Arrays.equals((byte[])localObject, paramPackageInfo)) {
            break label131;
          }
          return (byte[])localObject;
        }
        catch (CertificateExpiredException paramPackageInfo)
        {
          Log.w("GooglePlayServicesUtil", "Certificate has expired.");
          return null;
        }
        catch (CertificateNotYetValidException paramPackageInfo)
        {
          Log.w("GooglePlayServicesUtil", "Certificate is not yet valid.");
          return null;
        }
        paramPackageInfo = paramPackageInfo;
        Log.w("GooglePlayServicesUtil", "Could not generate certificate.");
        return null;
      }
    }
    if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
      Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(paramPackageInfo, 0));
    }
    return null;
  }
  
  private static byte[][] a(byte[][]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[][] arrayOfByte1 = new byte[j][];
    int m = paramVarArgs.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      byte[][] arrayOfByte2 = paramVarArgs[j];
      k = 0;
      while (k < arrayOfByte2.length)
      {
        arrayOfByte1[i] = arrayOfByte2[k];
        k += 1;
        i += 1;
      }
      j += 1;
    }
    return arrayOfByte1;
  }
  
  private static byte[] au(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static boolean b(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    int i = 0;
    paramFragment = a(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (paramFragment == null) {
      return false;
    }
    try
    {
      boolean bool = paramActivity instanceof FragmentActivity;
      i = bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;) {}
    }
    if (i != 0)
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramFragment, paramOnCancelListener).show(paramActivity, "GooglePlayServicesErrorDialog");
    }
    for (;;)
    {
      return true;
      if (!iq.fX()) {
        break;
      }
      paramActivity = paramActivity.getFragmentManager();
      ErrorDialogFragment.newInstance(paramFragment, paramOnCancelListener).show(paramActivity, "GooglePlayServicesErrorDialog");
    }
    throw new RuntimeException("This Activity does not support Fragments.");
  }
  
  public static boolean b(PackageManager paramPackageManager)
  {
    synchronized (Df)
    {
      int i = De;
      if (i == -1) {}
      try
      {
        if (a(paramPackageManager.getPackageInfo("com.google.android.gms", 64), new byte[][] { Da[1] }) != null) {}
        for (De = 1; De != 0; De = 0) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        for (;;)
        {
          De = 0;
        }
      }
    }
    return false;
  }
  
  public static boolean b(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      return a(paramPackageManager, localPackageInfo);
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
        Log.d("GooglePlayServicesUtil", "Package manager can't find package " + paramString + ", defaulting to false");
      }
    }
    return false;
  }
  
  private static boolean b(Resources paramResources)
  {
    boolean bool2 = false;
    paramResources = paramResources.getConfiguration();
    boolean bool1 = bool2;
    if (iq.fZ())
    {
      bool1 = bool2;
      if ((paramResources.screenLayout & 0xF) <= 3)
      {
        bool1 = bool2;
        if (paramResources.smallestScreenWidthDp >= 600) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Deprecated
  public static Intent c(Context paramContext, int paramInt)
  {
    return Z(paramInt);
  }
  
  public static boolean c(PackageManager paramPackageManager)
  {
    return (b(paramPackageManager)) || (!et());
  }
  
  public static String d(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    default: 
      return localResources.getString(R.string.common_google_play_services_unknown_issue);
    case 1: 
      if (a(paramContext.getResources())) {
        return localResources.getString(R.string.common_google_play_services_install_text_tablet);
      }
      return localResources.getString(R.string.common_google_play_services_install_text_phone);
    case 3: 
      return localResources.getString(R.string.common_google_play_services_enable_text);
    case 2: 
      return localResources.getString(R.string.common_google_play_services_update_text);
    case 9: 
      return localResources.getString(R.string.common_google_play_services_unsupported_text);
    case 7: 
      return localResources.getString(R.string.common_google_play_services_network_error_text);
    case 5: 
      return localResources.getString(R.string.common_google_play_services_invalid_account_text);
    }
    return localResources.getString(R.string.common_google_play_services_unsupported_date_text);
  }
  
  public static String e(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      return paramContext.getString(17039370);
    case 1: 
      return paramContext.getString(R.string.common_google_play_services_install_button);
    case 3: 
      return paramContext.getString(R.string.common_google_play_services_enable_button);
    }
    return paramContext.getString(R.string.common_google_play_services_update_button);
  }
  
  public static boolean et()
  {
    if (Dc) {
      return Dd;
    }
    return "user".equals(Build.TYPE);
  }
  
  public static String f(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    default: 
      return paramContext.getString(R.string.common_google_play_services_unknown_issue);
    case 1: 
      return paramContext.getString(R.string.common_google_play_services_notification_needs_installation_title);
    case 2: 
      return paramContext.getString(R.string.common_google_play_services_notification_needs_update_title);
    case 3: 
      return paramContext.getString(R.string.common_google_play_services_needs_enabling_title);
    case 9: 
      return paramContext.getString(R.string.common_google_play_services_unsupported_text);
    case 7: 
      return paramContext.getString(R.string.common_google_play_services_network_error_text);
    case 5: 
      return paramContext.getString(R.string.common_google_play_services_invalid_account_text);
    }
    return paramContext.getString(R.string.common_google_play_services_unsupported_date_text);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    Intent localIntent = c(paramContext, paramInt1);
    if (localIntent == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, localIntent, 268435456);
  }
  
  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN_ERROR_CODE";
    case 0: 
      return "SUCCESS";
    case 1: 
      return "SERVICE_MISSING";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      return "SERVICE_DISABLED";
    case 4: 
      return "SIGN_IN_REQUIRED";
    case 5: 
      return "INVALID_ACCOUNT";
    case 6: 
      return "RESOLUTION_REQUIRED";
    case 7: 
      return "NETWORK_ERROR";
    case 8: 
      return "INTERNAL_ERROR";
    case 9: 
      return "SERVICE_INVALID";
    case 10: 
      return "DEVELOPER_ERROR";
    case 11: 
      return "LICENSE_CHECK_FAILED";
    }
    return "DATE_INVALID";
  }
  
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    Object localObject = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
    try
    {
      InputStream localInputStream = paramContext.getContentResolver().openInputStream((Uri)localObject);
      try
      {
        paramContext = new Scanner(localInputStream).useDelimiter("\\A").next();
        localObject = paramContext;
        if (localInputStream != null)
        {
          localInputStream.close();
          return paramContext;
        }
      }
      catch (NoSuchElementException paramContext)
      {
        paramContext = paramContext;
        if (localInputStream == null) {
          break label101;
        }
        localInputStream.close();
        break label101;
      }
      finally
      {
        paramContext = finally;
        if (localInputStream != null) {
          localInputStream.close();
        }
        throw paramContext;
      }
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      localObject = null;
    }
    label101:
    return null;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (System.currentTimeMillis() < 1227312000288L) {
        return 12;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      }
      x(paramContext);
      PackageInfo localPackageInfo;
      try
      {
        localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        if (!ij.aD(localPackageInfo.versionCode)) {
          break label307;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        try
        {
          paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 64);
          if (et()) {
            break label211;
          }
          if (a(localPackageInfo, new byte[][] { CS[1], CX[1] }) != null) {
            break label146;
          }
          Log.w("GooglePlayServicesUtil", "Google Play services signature (test key) invalid on Glass.");
          return 9;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("GooglePlayServicesUtil", "Calling package info missing.");
          return 9;
        }
        paramContext = paramContext;
        Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
        return 1;
      }
      label146:
      tmp151_148[0] = CS[1];
      byte[][] tmp159_151 = tmp151_148;
      tmp159_151[1] = CX[1];
      if (a(paramContext, tmp159_151) == null)
      {
        Log.w("GooglePlayServicesUtil", "Calling package " + paramContext.packageName + " signature (test key) invalid on Glass.");
        return 9;
        label211:
        if (a(localPackageInfo, new byte[][] { CS[0], CX[0] }) == null)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid (release key) on Glass.");
          return 9;
        }
        if (a(paramContext, new byte[][] { CX[0] }) == null)
        {
          Log.w("GooglePlayServicesUtil", "Calling package " + paramContext.packageName + " signature (release key) invalid on Glass.");
          return 9;
          label307:
          if (ij.C(paramContext))
          {
            if (a(localPackageInfo, CS) == null)
            {
              Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
              return 9;
            }
          }
          else
          {
            try
            {
              paramContext = localPackageManager.getPackageInfo("com.android.vending", 64);
              paramContext = a(paramContext, CS);
              if (paramContext == null)
              {
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                return 9;
              }
            }
            catch (PackageManager.NameNotFoundException paramContext)
            {
              Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
              return 9;
            }
            if (a(localPackageInfo, new byte[][] { paramContext }) == null)
            {
              Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
              return 9;
            }
          }
        }
      }
      int i = ij.aB(5077000);
      if (ij.aB(localPackageInfo.versionCode) < i)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 5077000 but found " + localPackageInfo.versionCode);
        return 2;
      }
      try
      {
        paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
        if (!paramContext.enabled) {
          return 3;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
        paramContext.printStackTrace();
        return 1;
      }
    }
    return 0;
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return b(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    Notification localNotification = new Notification(17301642, localResources.getString(R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
    localNotification.flags |= 0x10;
    String str1 = f(paramContext, paramInt);
    String str2 = y(paramContext);
    localNotification.setLatestEventInfo(paramContext, str1, localResources.getString(R.string.common_google_play_services_error_notification_requested_by_msg, new Object[] { str2 }), getErrorPendingIntent(paramInt, paramContext, 0));
    ((NotificationManager)paramContext.getSystemService("notification")).notify(39789, localNotification);
  }
  
  public static void w(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = c(paramContext, i);
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  private static void x(Context paramContext)
  {
    Object localObject = null;
    int i;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = paramContext.metaData;
      if (paramContext == null) {
        break label115;
      }
      i = paramContext.getInt("com.google.android.gms.version");
      if (i == 5077000) {
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", paramContext);
        paramContext = (Context)localObject;
      }
    }
    throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 5077000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    label115:
    throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  private static String y(Context paramContext)
  {
    Object localObject2 = paramContext.getApplicationInfo().name;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramContext.getPackageName();
      localObject2 = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      paramContext = ((PackageManager)localObject2).getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        localObject1 = ((PackageManager)localObject2).getApplicationLabel(paramContext).toString();
      }
      return (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/GooglePlayServicesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */