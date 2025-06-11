<!DOCTYPE html>
<html>

<head>
    <title>Cat List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Cat List</h1>
        <a href="/cats/new" class="btn btn-primary mb-3">Add New Cat</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Breed</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Age</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list catslist as cat>
                    <tr>
                        <td>${cat.cat}</td>
                        <td>${cat.breed}</td>
                        <td>${(cat.description!"")?substring(0, [50, cat.description?length]?min)}<#if
                                (cat.description!"")?length gt 50>...</#if>
                        </td>
                        <td>${cat.age} years</td>
                        <td>
                            <a href="/cats/${cat.catId}" class="btn btn-info btn-sm">View</a>
                            <a href="/cats/edit/${cat.catId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/cats/delete/${cat.catId}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>

</html>