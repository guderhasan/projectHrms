package com.example.demo.business.abstracts;


import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
Result setLanguages(ForeignLanguage foreignLanguage);
}
