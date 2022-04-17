create sequence students_student_id_seq;

CREATE TABLE IF NOT EXISTS students
(
    student_id INTEGER PRIMARY key DEFAULT nextval('students_student_id_seq'),
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    middle_name VARCHAR(80) NOT NULL,
    date_of_birth date NOT NULL,
    class_name VARCHAR(30) NOT NULL,
    limited_health_options boolean NOT NULL,
    disability boolean NOT NULL,
    paid_meals int NOT NULL,
    social_help_before date NOT NULL
);

CREATE TABLE IF NOT EXISTS visits
(
    student_id INTEGER REFERENCES students(student_id),
    date_of_meals date NOT NULL,
    ate_meal boolean NOT NULL,
    drank_milk boolean NOT NULL,
    last_update date NOT NULL,
    PRIMARY KEY (student_id, date_of_meals)
);
