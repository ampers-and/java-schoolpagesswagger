package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "instructorService")
public class InstructorServiceImpl implements InstructorService
{
    @Autowired
    private InstructorRepository instructrepos;

    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (instructrepos.findById(id).isPresent())
        {
            instructrepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Instructor save(Instructor instructor)
    {
        Instructor newInstructor = new Instructor();

        newInstructor.setInstructname(instructor.getInstructname());

        return instructrepos.save(newInstructor);
    }

    @Override
    public Instructor update(Instructor instructor, long id)
    {
        Instructor currentInstructor = instructrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (instructor.getInstructname() != null)
        {
            currentInstructor.setInstructname(instructor.getInstructname());
        }

        return instructrepos.save(currentInstructor);
    }
}
