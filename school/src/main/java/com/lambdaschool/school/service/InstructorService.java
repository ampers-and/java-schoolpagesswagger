package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Instructor;

public interface InstructorService
{
    void delete(long id);

    Instructor save (Instructor instructor);

    Instructor update(Instructor instructor, long id);
}
