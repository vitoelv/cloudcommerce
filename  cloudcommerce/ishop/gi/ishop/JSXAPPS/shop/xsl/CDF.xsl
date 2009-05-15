<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ns1="http://ws.jcommerce.com/">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<data jsxid="jsxroot">
	<xsl:for-each select="//ns1:Category">
	<record>
	<xsl:attribute name="jsxid" >
	<xsl:value-of select="position()"/>
	</xsl:attribute>
	<xsl:attribute name="id">
	<xsl:value-of select="./ns1:id"/>
	</xsl:attribute>
	<xsl:attribute name="name">
	<xsl:value-of select="./ns1:name"/>
	</xsl:attribute>
	<xsl:attribute name="parent">
	<xsl:value-of select="./ns1:parent"/>
	</xsl:attribute>
	<xsl:for-each select="./ns1:children/ns1:id">
	<record>
	<xsl:attribute name="jsxid">
	<xsl:value-of select="position()"/>
	</xsl:attribute>
	<xsl:attribute name="childrenId">
	<xsl:value-of select="."/>
	</xsl:attribute>
	</record>
	</xsl:for-each>
	</record>
	</xsl:for-each>
	</data>
	</xsl:template>
	
</xsl:stylesheet>
