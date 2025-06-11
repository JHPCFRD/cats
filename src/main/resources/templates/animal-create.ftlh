<!DOCTYPE html>
<html>

<head>
    <title>Create New Cat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <h1>Add new cat</h1>
        <form action="/cats/new" method="post">
            <div class="mb-3">
                <label for="breed" class="form-label">Breed</label>
                <input type="text" class="form-control" id="breed" name="breed" required>
            </div>

            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input class="form-control" id="name" name="name" required>
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea type="text" class="form-control" id="description" name="description" required> </textarea>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/cats" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>

</html>