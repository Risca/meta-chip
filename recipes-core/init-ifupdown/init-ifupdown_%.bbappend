# Customization of init-ifupdown

# Files directory
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Sources
SRC_URI:append = " \
    file://interfaces \
"
