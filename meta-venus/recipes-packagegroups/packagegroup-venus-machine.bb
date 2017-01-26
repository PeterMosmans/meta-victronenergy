SUMMARY = "common machine specific venus base packages"
DESCRIPTION = "see packagegroup-venus-base, this contain the per MACHINE base adjustments."

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
LICENSE = "MIT"


DEPENDS_append_ccgx += "\
	qtbase \
	qtserialport \
"

DEPENDS_append_ccgxhf += "\
	qtbase \
	qtserialport \
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

RDEPENDS_${PN}_append_ccgxhf += "\
	gpio-export \
	mtd-utils \
	mtd-utils-ubifs \
	prodtest \
	swupdate \
	swupdate-scripts \
"

RDEPENDS_${PN}_append_beaglebone += "\
	bluez5 \
	bluez5-noinst-tools \
	gpio-export \
	i2c-tools \
	linux-firmware-rtl8723b \
	prodtest \
	swupdate \
	swupdate-scripts \
"
