<!DOCTYPE html>
<html>

<head>
    <title>Cat Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Cat Details</h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${cat.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">
                    Description: ${cat.description!''} |
                    Age: ${cat.age} years
                </h6>
                <p class="card-text">${cat.name}</p>
                <div class="mt-4">
                    <a href="/cats/edit/${cat.catId}" class="btn btn-warning">Edit</a>
                    <a href="/cats" class="btn btn-secondary">Back to List</a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>