CREATE TABLE IF NOT EXISTS Task(
  id IDENTITY PRIMARY KEY,
  header VARCHAR,
  status VARCHAR,
  description VARCHAR
);
DELETE FROM Task;
INSERT INTO Task VALUES(1,'Task1', 'done', 'Do something');
INSERT INTO Task VALUES(2, 'Task2', 'inprogress', 'Do something else');
INSERT INTO Task VALUES(3, 'Task3','new', 'Test application');