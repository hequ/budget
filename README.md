# Personal Budget

# Development

## Database

Database schema is managed by flyway and the underlaying database is Postgresql.

### Create new database with docker:

For the first run you can use the official postgres docker image to set up the database.

`docker run --name budget-postgres -e POSTGRES_PASSWORD=pass -d -p 5432:5432 postgres`

### Connecting to dev database with psql:

`docker run -it --rm --link budget-postgres:postgres postgres psql -h postgres -U postgres budget`
