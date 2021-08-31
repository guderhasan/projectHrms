package com.example.demo.business.abstracts;
import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;
public interface UsersService {
DataResult<List<Users>> getAll();


}
