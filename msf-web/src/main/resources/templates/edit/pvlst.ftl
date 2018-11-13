<html>
<head>
    <style>
        th,td{
            border: 1px solid #ccc;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>ip</th>
        <th>位置</th>
        <th>时间</th>
    </tr>
<#list pvLst as item>
    <tr>
        <td>${item.id}</td>
        <td>${item.ip}</td>
        <td>${item.position}</td>
        <td>${item.createdOn}</td>
    </tr>
</#list>
</table>

</body>
</html>