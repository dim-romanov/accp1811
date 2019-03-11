<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="empl">
        <html>
            <head>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
                      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
                      crossorigin="anonymous"/>
            </head>
            <body>
                <h1>Сотрудники</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>name</td>
                            <td>age</td>
                            <td>salary</td>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="user">
                            <!--<xsl:sort select="salary" order="descending" data-type="number"></xsl:sort>-->
                            <xsl:sort select="name"  data-type="text"></xsl:sort>
                            <!--<xsl:if test="age>=19">-->
                            <!--<xsl:if test="age>=19 and salary &lt; 10000 ">-->
                                <tr>
                                    <td>
                                        <xsl:value-of select="id"></xsl:value-of>
                                    </td>
                                    <td>
                                        <xsl:value-of select="name"></xsl:value-of>
                                    </td>
                                    <td>
                                        <xsl:value-of select="age"></xsl:value-of>
                                    </td>
                                    <td>
                                        <xsl:value-of select="salary"></xsl:value-of>
                                    </td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="salary>100000">Большая</xsl:when>
                                            <xsl:when test="salary>5000">Средняя</xsl:when>
                                            <xsl:otherwise>Низкая</xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                </tr>
                            <!--</xsl:if>-->
                        </xsl:for-each>

                    </tbody>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>