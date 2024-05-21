DESCRIPTION = "Linux Kernel for C.H.I.P. boards"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "chip|chip-pro"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRCREV ?= "bce5de1cdc3667a2bc454219a0856b4f415b33f5"
KERNEL_VERSION_SANITY_SKIP = "1"

SRC_URI += " \
    git://github.com/joelguittet/chip-linux.git;protocol=https;branch=nextthing/4.4/chip \
    file://defconfig \
    file://0001-scripts-dtc-Remove-redundant-YYLOC-global-declaration.patch \
    file://0002-Fix-compilation-with-gcc-8.patch \
    file://0003-give-up-on-gcc-ilog2-constant-optimizations.patch \
"

LINUX_VERSION ?= "4.4"
PV = "${LINUX_VERSION}+git${SRCPV}"

S = "${WORKDIR}/git"

# Automatically depend on lzop-native if CONFIG_KERNEL_LZO is enabled
python () {
    try:
        defconfig = bb.fetch2.localpath('file://defconfig', d)
    except bb.fetch2.FetchError:
        return

    try:
        configfile = open(defconfig)
    except IOError:
        return

    if 'CONFIG_KERNEL_LZO=y\n' in configfile.readlines():
        depends = d.getVar('DEPENDS', False)
        d.setVar('DEPENDS', depends + ' lzop-native')
}
