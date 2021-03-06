DESCRIPTION = "DBusrecorder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit allarch
inherit ve_package

RDEPENDS_${PN} = "python-dbus"

SRC_URI = " \
	git://github.com/victronenergy/dbus-recorder.git;protocol=https;tag=${PV} \
	file://startdemo.sh \
	file://stopdemo.sh \
"
S = "${WORKDIR}/git"

do_install () {
	install -d ${D}/${bindir}

	install -m 0755 ${WORKDIR}/startdemo.sh ${D}/${bindir}
	install -m 0755 ${WORKDIR}/stopdemo.sh ${D}/${bindir}

	# copy python scripts
	install -m 755 -D ${S}/*.py ${D}/${bindir}
	# copy data files
	install -m 444 -D ${S}/*.dat ${D}/${bindir}
}


