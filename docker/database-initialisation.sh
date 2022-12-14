#!/bin/bash
set -e

# Create a new user to manage the application database
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  CREATE USER $APP_DB_USER WITH ENCRYPTED PASSWORD '$APP_DB_PASS' CREATEDB CREATEROLE LOGIN;
  CREATE DATABASE $APP_DB_NAME;
  GRANT ALL PRIVILEGES ON DATABASE $APP_DB_NAME TO $APP_DB_USER;
EOSQL

# Create a new schema under the newly created user
export PGPASSWORD=$APP_DB_PASS
psql -v ON_ERROR_STOP=1 --username "$APP_DB_USER" --dbname "$APP_DB_NAME" <<-EOSQL
  CREATE SCHEMA $APP_SCHEMA_NAME;
EOSQL

