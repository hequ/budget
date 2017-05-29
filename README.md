# Personal Budget

# Development

## Environment

This project uses environ to handle the environment variables. While developing, you should add `profiles.clj` file to the root of this project with the following contents:

```
{:dev {:env {:db-user "user"
             :db-pass "pass"}}}
```

This way your environment is set while developing with REPL.

## Database

Database schema is managed by flyway and the underlaying database is Postgresql.

### Create new database with docker:

For the first run you can use the official postgres docker image to set up the database.

`docker run --name budget-postgres -e POSTGRES_PASSWORD=pass -d -p 5432:5432 postgres`

### Connecting to dev database with psql:

`docker run -it --rm --link budget-postgres:postgres postgres psql -h postgres -U postgres budget`

### Test commands for quick testing

`curl -H "Content-Type: application/json" -X POST -d '{"lol": "bal"}' http://localhost:5000/purchase`
