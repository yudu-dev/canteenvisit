CREATE TABLE IF NOT EXISTS students
(
    student_id serial PRIMARY KEY,
    first_name VARCHAR(80) NOT NULL,
    second_name VARCHAR(80) NOT NULL,
    middle_name VARCHAR(80) NOT NULL,
    date_of_birth date NOT NULL,
    class_name VARCHAR(30) NOT NULL,
    limited_health_options boolean NOT NULL,
    disability boolean NOT NULL,
    paid_meals int NOT NULL,
    social_help_before date NOT NULL,
    ate_food boolean NOT NULL,
    drank_milk boolean NOT NULL
);