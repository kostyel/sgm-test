#!/bin/bash
psql -v ON_ERROR_STOP=1 --username postgres <<-EOSQL

  CREATE ROLE core WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  PASSWORD '12345';

  CREATE DATABASE coredb
    WITH OWNER = core
         ENCODING = 'UTF8'
         TABLESPACE = pg_default
         LC_COLLATE = 'en_US.utf8'
         LC_CTYPE = 'en_US.utf8'
         CONNECTION LIMIT = -1;
  GRANT CONNECT, TEMPORARY ON DATABASE coredb TO public;

  GRANT ALL ON DATABASE coredb TO core;

EOSQL

psql -v ON_ERROR_STOP=1 --username core coredb <<-EOSQL

  CREATE SCHEMA bs
      AUTHORIZATION core;

  GRANT ALL ON SCHEMA bs TO core;
EOSQL

