DESCRIPTION = "Package group WiFi"
LICENSE = "MIT"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN}:chip = " \
  packagegroup-base-wifi \
  rtl8723bs \
  dhcp-client \
  wireless-regdb \
"

RDEPENDS:${PN}:chip-pro = " \
  packagegroup-base-wifi \
  rtl8723ds \
  dhcp-client \
  wireless-regdb \
"
