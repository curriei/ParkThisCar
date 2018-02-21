//Parking signs module//

/*Goals
-Information on sign
-Return lattitude and longitude of sign
-Category of sign
-Distance between sign and coordinate


Information on sign
Each sign is one of these.
There are the following signs in row "L" that correspond to these categories
P1H - 1 HOUR PARKING OR MORE
PBLO - BUS LAYOVER 
PBZ - BUS ZONE 
PCARPL -  CARPOOL SIGNED PARKING
PCVL - COMMERCIAL VEHICAL LOAD ZONES
PDIS - DISABLED PARKING
PGA - EXXEMPT VEHICLES ONLY : POLICE, FIRE, HEALTH
PINST - GEOGRAPHICAL DIRECTION OF PARKING AREA
PLU - 15/30 MINUTE LOAD ZONES, MAY BE PAID
PNP - NO PARKING BUT STANDING ALLOWD
PNS - NO STOPPING STANDING OR PARKING
PPEAK - TOW ZONE, PEAK PARKING RESTRICTIONS
PPL - 3 MINUTE PARKING LOAD ZONE
PPP - SHORT TERM PAID PARKING 15 - 4 HOURS
PR - PARKING REGULATORY
PRZ - RESTRICTED PARKING
PS - PAY STATION
PSCH - SCHOOL OR BUS LOAD
PTIML - 15/30 MIN SHORT TERM PARKING
PTRKL - 30 MINUTE TRUCK LOAD ZONE
PZONE - INCLUDES CHARTER BUS, EVENT, CARSHARE

Other information can be returend via the "K" coloumn including infromational text
Colomun "W" also gives the same information

Lattitude and Longittude:
Section "AB" of file
(Latitude, Longitude)

Hours:
Calculation of hours can be as follows
Return "Z" column for Start hour of parking
Return "AA" column for End hour of parking

Days:
Calculation of days where sign rules are enforced are as follows
Return "X" - Start Day
Return "Z" - End Day



