DESCRIPTION = "Package group JAVA with OpenJDK DIO"
LICENSE = "MIT"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
  chip-packagegroup-java \
  openjdk-dio \
"
