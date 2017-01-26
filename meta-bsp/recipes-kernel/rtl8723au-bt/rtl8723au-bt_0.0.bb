SUMMARY = "Add the rtl8723bu driver from Larry Finger as an out-of-tree module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

# When building on openembedded Jethro, or older versions, make sure to apply
# this commit:
# https://github.com/openembedded/openembedded-core/commit/afcea61e8eb39234d336c706fdfd4680dea7c060
# to prevent warnings exactly like mentioned in that commit message.

inherit module

SRC_URI = " \
	gitsm://github.com/lwfinger/rtl8723au_bt.git;protocol=https;branch=kernel;rev=a96694875e8f39f3c1aa13da91ab942dcb84df07 \
	file://0001-fix-makefile.patch \
"

S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

do_install() {
    # Modules
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/bluetooth
    install -m 0644 btrtl.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/bluetooth
    install -m 0644 btusb.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/bluetooth
}
