## Locations

* `adb`: `users/wittern/Library/Android/sdk/platform-tools`

* `emulator`: `users/wittern/Library/Android/sdk/tools`


## Install .apk file

1. Locate adb in `users/wittern/Library/Android/sdk/platform-tools`

2. Copy <name>.apk file into `platform-tools`

3. Start Android Vidrual Device (AVD) 
  3.1. From Android Studio application
  3.2. From `../Android/sdk/tools` using `./emulator -avd Nexus_5_API_23_x86`

4. Install .adk using:

    ./adb install <name>.apk


## Monitor traffic - HTTP Proxy, e.g., mitmproxy

1. Run mitmproxy (from `mitmproxy` folder):

    ./mitmdump --host --anticache -p 8888 -s "format_output.py surfen.txt"

2. Run emulator (from `Library/Android/sdk/tools` folder):

    ./emulator -http-proxy localhost:8080 -avd Nexus_4_API_17 

  (unlock with 5695)

3. (Optional: install certificate by using broswer and going to `mitm.it`. Click on Android and follow the instructions...)

4. (Optional: point virtual device to `10.0.2.2:8888` in Settings -> Wireless & Networks -> Mobile networks -> Access Point Names -> T-Mobile US)


## Monitor traffic - tcpdump

1. Run emulator:

    ./emulator -tcpdump emulator.cap -avd Nexus_5_API_23_x86

2. Analyze output in `emulator.cap` (in `../Android/sdk/tools`) in WireShark


## Troubleshooting

    adb kill-server
    adb devices


## Apps to test:
Lep's World (361) https://archive.org/download/playdrone-apk-46/at.nerbrothers.SuperJump-17.apk
Xperia Z Live Wallpaper (1774) https://archive.org/download/playdrone-apk-d3/com.androidwasabi.livewallpaper.xperiaz-13.apk
MP3 Cutter and Ringtone Maker♫ (1194) https://archive.org/download/playdrone-apk-58/com.atomic.apps.ringtone.cutter-100007.apk
Paper Toss (87) https://archive.org/download/playdrone-apk-1d/com.bfs.papertoss-7005.apk
Fotor Photo Editor (4003) - https://archive.org/download/playdrone-apk-38/com.everimaging.photoeffectstudio-85.apk
HangMan (3219) https://archive.org/download/playdrone-apk-8d/com.games.HangManGame-14.apk
GO Weather Forecast & Widgets (80) https://archive.org/download/playdrone-apk-d8/com.gau.go.launcherex.gowidget.weatherwidget-124.apk
Pocket (1323) https://archive.org/download/playdrone-apk-ed/com.ideashower.readitlater.pro-568.apk
Bubble Blast ! (4127) https://archive.org/download/playdrone-apk-6f/com.magmamobile.game.BubbleBlast-23.apk
Quick PDF Scanner FREE (3069) https://archive.org/download/playdrone-apk-3f/com.mobisystems.mobiscanner-213.apk
Nearby Messenger (Random Chat) (2424) https://archive.org/download/playdrone-apk-a7/com.pioong-93.apk
Tapatalk (1990) https://archive.org/download/playdrone-apk-d7/com.quoord.tapatalkpro.activity-453.apk
Rage Meme Camera Free (2236) https://archive.org/download/playdrone-apk-72/com.troll.face-25.apk
Retrica (90) https://archive.org/download/playdrone-apk-d6/com.venticake.retrica-21.apk
Ultimate Logo Quiz (999) https://archive.org/download/playdrone-apk-22/logo.quiz.game.category-48.apk
BeyondPod Podcast Manager (2616) https://archive.org/download/playdrone-apk-55/mobi.beyondpod-3368.apk
Broken Screen: Cracked Prank (1784) https://archive.org/download/playdrone-apk-97/mobi.borken.android.brokenscreen-20.apk
iFunny :) (1007) https://archive.org/download/playdrone-apk-cb/mobi.ifunny-2447.apk
Wisielec (3126) https://archive.org/download/playdrone-apk-57/pl.macaque.hangmanpl-6.apk
Where is that? (3124) - https://archive.org/download/playdrone-apk-57/com.jaysquared.games.whereishd.releasefree-72.apk


## Apps that couldn't be installed:
101-in-1 Games (427)
CITY BUS SIMULATOR (4370)
Make-Up Me (3125)
Nail Makeover - Girls Games (1285)
Island Car Racing 3D (4672)
Dress up -Art nail girls (3658)
Crazy Snowboard (1551)
Star Warfare:Alien Invasion HD (4511)
Design It! Fashion & Makeover (2370)
MoviePop (4483) - https://archive.org/download/playdrone-apk-04/air.com.freshplanet.games.MoviePop-1001007.apk
Waxing Salon (4084) - https://archive.org/download/playdrone-apk-b7/com.games4girls.WaxingSalon-337.apk
Bike Race Free - Top Free Game (79) https://archive.org/download/playdrone-apk-33/com.topfreegames.bikeracefreeworld-2014082110.apk
Escape Action (1002) https://archive.org/download/playdrone-apk-14/henrich.thandroid.floor-8.apk
Toy Truck Rally 3D (296)
Army Sniper (861) - https://archive.org/download/playdrone-apk-7e/com.sniper.activity-12.apk
volume booster (2684) - https://archive.org/download/playdrone-apk-a4/com.feaclipse.volume.booster-16.apk


## Apps that don't run:
Slots - Pharaoh's Way (2175)
Temple Run (75)
Polaris Office + PDF (1331)
SoundHound (78)
Fruits Legend (1178)
Treasures of Montezuma 3 free (4556)
BIG WIN Basketball (1896)
Car Wash - Kids game (2524)
Dental Braces - Oral Surgery (3623)
Fruits Legend (1178)
Gems Journey (3932)
MP3 Video Converter (161)
PEN.UP (922)
Rope Escape (1416)
Workout Trainer (428)
BIG WIN Basketball (1896)
Autumn live wallpaper (4794)
Fastest Video Downloader (1349)
Slots Casino Party™ (2316)
PGA TOUR (2750) - https://archive.org/download/playdrone-apk-5c/com.tour.pgatour-44.apk
FLV Player (alpha version) (2575) - https://archive.org/download/playdrone-apk-dd/jp.adlibjapan.flvplayer-2012033101.apk
GRave Defense HD Free (2942) - https://archive.org/download/playdrone-apk-7d/com.artofbytes.gravedefence.hd.free-46.apk
NinJump (780) - https://archive.org/download/playdrone-apk-e7/com.bfs.ninjump-7008.apk
Free Video Calls V.S (3002) - https://archive.org/download/playdrone-apk-1d/com.instantmessenger.videoCompare-5.apk
Hulu (158) - https://archive.org/download/playdrone-apk-34/com.hulu.plus-202060.apk
Pet Rescue Saga (156) - https://archive.org/download/playdrone-apk-d7/com.king.petrescuesaga-10300405.apk
The Night Sky Lite (2427) - https://archive.org/download/playdrone-apk-b5/com.icandiapps.thenightskylite-8.apk
Birthdays - Free (4862) - Requires Google Services which are unavailable
Stand O'Food® (4540) - https://archive.org/download/playdrone-apk-52/com.g5e.standofood-8.apk
Cartoon Camera (230) - https://archive.org/download/playdrone-apk-ea/com.fingersoft.cartooncamera-13.apk
Word Search Puzzles (1617) - https://archive.org/download/playdrone-apk-a6/com.icemochi.wordsearch-19.apk
Where is that? (3124) - https://archive.org/download/playdrone-apk-57/com.jaysquared.games.whereishd.releasefree-72.apk


## Unsuited Apps (e.g., system services, not usable for me)
Atomic functionality:
---------------------
Dubai Night Live Wallpaper (2512) https://archive.org/download/playdrone-apk-46/com.DubaiNightLiveWallpaperHQ-9.apk
Nature Bliss Live Wallpaper (2554) https://archive.org/download/playdrone-apk-53/com.GalaxyS5LiveWallpaper-20.apk
Advanced Clock Widget (4171) - https://archive.org/download/playdrone-apk-7a/org.zooper.acw-762.apk
Galaxy S4 Rain Live Wallpaper (4422) - https://archive.org/download/playdrone-apk-39/com.androidwasabi.livewallpaper.s4drop-5.apk
Screenshot HD (4571)
Great HD Wallpapers (4536) - https://archive.org/download/playdrone-apk-8e/com.medoli.greathdwallpapers-31.apk

Unsuited:
---------
Firefox Browser for Android (83)
ANT+ Plugins Service (120)
Easy Tether Lite (No root) (3171) https://archive.org/download/playdrone-apk-df/com.mstream.easytether_beta-31.apk
Photon Flash Player & Browser (317) - https://archive.org/download/playdrone-apk-8d/com.appsverse.photon-27.apk

Language:
---------
顔文字パック♥毎日更新 (2615)
暴走列伝 単車の虎◆ヤンキー×バイク！無料不良バトル/単虎 (3381)

No calls:
---------
KeePassDroid (3451) https://archive.org/download/playdrone-apk-a2/com.android.keepass-129.apk (makes no calls)
AIMP [Beta] (4474) - https://archive.org/download/playdrone-apk-dc/com.aimp.player-139.apk (makes no calls)

JavaScript:
-----------
Kakao App (JS, signup required without Mailgator)
Job Search (992) https://archive.org/download/playdrone-apk-f1/com.indeed.android.jobsearch-17.apk
