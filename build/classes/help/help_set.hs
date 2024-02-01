
<helpset version = "1.0">
    <title>Ayuda</title>
    <maps>
        <homeID>Indice</homeID>
        <mapref location = "map_file.jhm"/>
    </maps>

    <view>
        <name>Busqueda</name>
        <label>Buscar</label>
        <type>javax.help.SearchView</type>
        <data engine = "com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch </data>
    </view>

    <view>
        <name>Indice</name>
        <label>Indice</label>
        <type>javax.help.IndexView</type>
        <data>index.xml</data>
    </view>

    <view>
        <name>Tabla de contenido</name>
        <label>Tabla de contenido</label>
        <type>javax.help.TOCView</type>
        <data>toc.xml</data>
    </view>
</helpset>