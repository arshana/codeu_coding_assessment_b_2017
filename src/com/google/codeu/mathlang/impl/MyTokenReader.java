// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.mathlang.impl;

import java.io.IOException;

import java.util.Scanner;

import com.google.codeu.mathlang.core.tokens.Token;
import com.google.codeu.mathlang.parsing.TokenReader;

// MY TOKEN READER
//
// This is YOUR implementation of the token reader interface. To know how
// it should work, read src/com/google/codeu/mathlang/parsing/TokenReader.java.
// You should not need to change any other files to get your token reader to
// work with the test of the system.
public final class MyTokenReader implements TokenReader {

  private String source;

  public MyTokenReader(String source) {
    // Your token reader will only be given a string for input. The string will
    // contain the whole source (0 or more lines).
    this.source = source.trim();
  }

  // NEXT
  //
  // Get the next token in the stream. When the end of stream has been reached
  // |next| should return |null|. The only valid tokens that can be returned are:
  //  - com.google.codeu.mathlang.core.tokens.StringToken
  //  - com.google.codeu.mathlang.core.tokens.NameToken
  //  - com.google.codeu.mathlang.core.tokens.SymbolToken
  //  - com.google.codeu.mathlang.core.tokens.NumberToken
  // If there is ever a problem with the source data, |next| should throw an
  // IOException.
  @Override
  public Token next() throws IOException {
    // Most of your work will take place here. For every call to |next| you should
    // return a token until you reach the end. When there are no more tokens, you
    // should return |null| to signal the end of input.

    // If for any reason you detect an error in the input, you may throw an IOException
    // which will stop all execution.
    try {
      Token retToken = null;
      if (source.length > 0) {
        if (!source.endsWith(";")){
          throw new IOException();
        }
        String[] lines = source.split(";");
        for(int i = 0; i < lines.length; i++){
          String funcType = lines[i].substring(0, indexOf(' ')).trim();
          String restOfLine = lines[i].substring(indexOf(' ')).trim();
          if (funcType.equals("let")){

          } else if(funcType.equals("note")){
            if (!restOfLine.startsWith("\"")){
              throw new IOException();
            }

          } else if(funcType.equals("print")){

          } else{
            throw new IOException();
          }
        }
      }
      return retToken;
    }
    catch (Exception ex){
      throw new IOException();
    }
  }
}
