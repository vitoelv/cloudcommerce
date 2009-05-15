<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match="/">
  <xsl:element name="data">
     <xsl:attribute name="jsxid">jsxroot</xsl:attribute>
     <record jsxid="a" jsxtext="请选择"/>
     <xsl:for-each select="data/record">
     <xsl:element name="record">
     <xsl:attribute name="jsxid"><xsl:value-of select="@jsxid"/></xsl:attribute>
     <xsl:attribute name="jsxtext"><xsl:value-of select="@name"/></xsl:attribute>
     </xsl:element>
     </xsl:for-each>
  </xsl:element>
 </xsl:template>
</xsl:stylesheet>