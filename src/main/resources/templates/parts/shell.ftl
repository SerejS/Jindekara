<#macro page>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Jindekara</title>
    <meta charset="UTF-8">
    <style>
        html {
            background-color: gray !important;
            background-size: cover;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css">
</head>

<body>

<#include "navbar.html">

<section class="section">
    <div class="container">
        <#nested>
    </div>
</section>
</body>

<script type="text/javascript">
    <#include "../static/modal.js">
</script>

</html>
</#macro>
