<!DOCTYPE html>
<html>

<head>
    <title>Edit Cat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Edit Cat</h1>

        <form action="/cats/update" method="post">
            <input type="hidden" name="catId" value="${cat.catId}">

            <div class="mb-3">
                <label for="breed" class="form-label">Breed</label>
                <input type="text" class="form-control" id="breed" name="breed" value="${cat.breed}" required>
            </div>

            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="form-control" id="name" name="name" value="${cat.name}" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="text" class="form-control" id="description" name="description" value="${cat.description!''}"></textarea>
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age" value="${cat.age}">
            </div>

            <button type="submit" class="btn btn-primary">Update</button>
            <a href="/cats/${cat.catId}" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>

</html>