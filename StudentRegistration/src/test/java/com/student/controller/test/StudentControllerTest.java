package com.student.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.student.StudentRegistrationApplication;
import com.student.controller.StudentController;
import com.student.dao.CourseDAO;
import com.student.dao.StudentDAO;
import com.student.serviceimpl.UniversityImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=StudentRegistrationApplication.class)
public class StudentControllerTest {
	
    private MockMvc mockMvc;
    
    @Mock
    private UniversityImpl universityImpl;
    
    @Mock
    private StudentDAO studentDao;
    
    @Mock
    private CourseDAO courseDao;

    @InjectMocks
    private StudentController studentController;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(studentController)
                .build();
    }

  	@Test
    public void testGetUniversity() throws Exception {
        this.mockMvc.perform(get("/university"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

    }
  	
  	@Test
    public void testGetStudents() throws Exception {
        this.mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

    }
}



