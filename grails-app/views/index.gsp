<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>DashBoard</title>
    <base href="/">
</head>

<body>

<navigation-bar></navigation-bar>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>

        <div class="col-md-8">
            <div ui-view=""></div>
        </div>

        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
