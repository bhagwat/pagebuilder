<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>DashBoard</title>
    <base href="/">
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Page Builder</a>
        </div>

        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ui-sref-active="active"><a ui-sref="template.list">Template List</a></li>
                <li ui-sref-active="active"><a ui-sref="template.create">Template Create</a></li>
                <li ui-sref-active="active"><a ui-sref="model.list">Model List</a></li>
                <li ui-sref-active="active"><a ui-sref="model.create">Model Create</a></li>
                <li ui-sref-active="active"><a ui-sref="page.list">Page List</a></li>
                <li ui-sref-active="active"><a ui-sref="page.create">Page Create</a></li>
            </ul>
        </div>
    </div>
</nav>

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
