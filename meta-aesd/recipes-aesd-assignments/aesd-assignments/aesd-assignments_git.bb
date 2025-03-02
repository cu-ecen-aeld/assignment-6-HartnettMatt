# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Assignment repo URI
SRC_URI = "git://git@github.com/cu-ecen-aeld/assignments-3-and-later-HartnettMatt;protocol=ssh;branch=main"

PV = "1.0+git${SRCPV}"
# Most up to date git hash
SRCREV = "f2929cd2bcca47b5e37e942c2acd0deab99d012b"

# This sets your staging directory based on WORKDIR, where WORKDIR is defined at 
# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-WORKDIR
# We reference the "server" directory here to build from the "server" directory
# in your assignments repo
S = "${WORKDIR}/git/server"

# See https://git.yoctoproject.org/poky/plain/meta/conf/bitbake.conf?h=kirkstone
FILES:${PN} += "${bindir}/aesdsocket"
TARGET_LDFLAGS += "-pthread -lrt"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 aesdsocket ${D}${bindir}/aesdsocket
    install -m 0755 aesdsocket-start-stop.sh ${D}${bindir}/aesdsocket-start-stop.sh
}
