<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/nur">NUR</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="btn btn-secondary"  href="/book/user-book-list">Home</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-success" href="/admin/create-book">Create Book</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-danger" href="/admin/delete-book">Delete Book</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-warning" href="/admin/update-book">Delete Book</a>
                </li>
                <li class="nav-item dropdown">
                    <select class="form-select" name="order" id="order_by" aria-label="Sort by">
                        <option value="title">Title</option>
                        <option value="new">New</option>
                        <option value="old">Old</option>
                        <option value="author">Author</option>
                    </select>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
