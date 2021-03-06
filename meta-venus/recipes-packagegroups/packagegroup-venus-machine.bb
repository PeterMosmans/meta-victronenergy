SUMMARY = "common machine specific venus base packages"
DESCRIPTION = "see packagegroup-venus-base, this contain the per MACHINE base adjustments."

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
LICENSE = "MIT"


DEPENDS_append_ccgx += "\
	qtbase \
	qtserialport \
	technexion-serial \
"

RDEPENDS_${PN} += "\
	simple-upnpd \
"

RDEPENDS_${PN}_append_ccgx += "\
	gpio-export \
	mtd-utils \
	mtd-utils-ubifs \
	prodtest \
	swupdate \
	swupdate-scripts \
"

RDEPENDS_${PN}_append_beaglebone += "\
	dnsmasq \
	gpio-export \
	hostapd \
	i2c-tools \
	prodtest \
	swupdate \
	swupdate-scripts \
"

RDEPENDS_${PN}_append_raspberrypi2 += "\
	swupdate \
	swupdate-scripts \
"
