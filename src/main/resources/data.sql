INSERT INTO classroom_tb (classroom_name, status)
VALUES ('Classroom 1', 'waiting');

INSERT INTO squad_tb (squad_name, classroom_id)
VALUES ('Squad A', 1), ('Squad B', 1), ('Squad C', 1), ('Squad D', 1), ('Squad E', 1);

INSERT INTO student_tb (student_name, classroom_id, squad_id)
VALUES
    ('Student 1', 1, 1), ('Student 2', 1, 1), ('Student 3', 1, 1), ('Student 4', 1, 1),
    ('Student 5', 1, 1), ('Student 6', 1, 2), ('Student 7', 1, 2), ('Student 8', 1, 2),
    ('Student 9', 1, 2), ('Student 10', 1, 2), ('Student 11', 1, 3), ('Student 12', 1, 3),
    ('Student 13', 1, 3), ('Student 14', 1, 3);

INSERT INTO coordinator_tb (coordinator_name, classroom_id)
VALUES ('Coordinator 1', 1);

INSERT INTO scrummaster_tb (scrum_master_name, classroom_id)
VALUES ('Scrum Master 1', 1);

INSERT INTO instructor_tb (instructor_name, classroom_id)
VALUES
    ('Instructor 1', 1), ('Instructor 2', 1), ('Instructor 3', 1);