<html>
<head>
    <title>Welcome!</title>
</head>
<body>

<p> The Items in our Catalog:</p>

<ul>
    <#list catalog as item>
        <li>
        <p>ID = ${item.getId()}</p>
        <p>Title = ${item.getTitle()}</p>
         <p>Location = ${item.getLocation()}</p>
        <b>Other properties:</b>
        <#list item.getProperties() as key,value>
            <p>${key}: ${value}</p>
        </#list>
            <b>Concepts:</b>
            <ul>
                <#list item.getConcepts() as concept>
                    <li>${concept}</li>
                </#list>
            </ul>
        </li>
    </#list>
</ul>

</body>
</html>