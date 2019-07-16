CREATE TABLE IF NOT EXISTS Task(
  id IDENTITY PRIMARY KEY,
  done VARCHAR,
  TEXT VARCHAR
);
DELETE FROM Task;
INSERT INTO Task VALUES(1, 'neww', 'Do something');
INSERT INTO Task VALUES(2, 'done', 'Do something else');
INSERT INTO Task VALUES(3, 'inprogress', 'Test application');