# RockPaperScissors
Implementation of a RESTful API for rock-paper-scissors game

Implementation Approach and Design Considerations: 

This RESTful API implementation of the rock-paper-scissors game uses Springboot 1.5.7 for ease of development.  
The game is treated as a singleton. It is designed to support extensibility of the game rules to support more than 3 gestures. 
The game is modeled as a collection of rounds where each round concludes with a winner for that round and the status of the game. 
The most rounds a player can win is set to 3 until then the status remains IN_PROGRESS. The first player who reaches a score of 3 wins and
the status is changed to GAME_OVER. The game is designed only for 2 player types; 
one human and one computer. They are abstracted into the game round and each player type maintains their respective scores.

The API is developed using Eclipse IDE and built with Maven. 
This is an implementation of a REST API that returns responses in JSON format. 

Using either one of the URLs below:
1.) http://localhost:8080/round?gesture=rock 
2.) http://localhost:8080/round?gesture=paper 
3.) http://localhost:8080/round?gesture=scissors 

initiates the game and returns a status code 200.

Sample response when status = GAME_OVER:
{
"timestamp": 1517302438710,
"status": 500,
"error": "Internal Server Error",
"exception": "com.transferwise.exam.exception.InvalidRoundRequestException",
"message": "GAME OVER! Only 3 rounds per game.",
"path": "/round"
}

At any time, you can evaluate the game by using:
http://localhost:8080/rps/rounds

1.) Sample response when calling http://localhost:8080/rps/rounds before the game is started:
{"roundDTOs":[]}
 
2.) Sample response when calling http://localhost:8080/rps/rounds while the game is IN_PROGRESS:
{"roundDTOs":[{"round":{"humanPlayer":{"gesture":"scissors","name":"Human Player","score":1},
                        "computerPlayer":{"gesture":"paper","name":"Computer Player","score":0},
                        "roundWinner":{"gesture":"scissors","name":"Human Player","score":1}
                       },
               "status":"IN_PROGRESS"
             }]
}

3.) Sample response when calling http://localhost:8080/rps/rounds when GAME_OVER:
{"roundDTOs":[{"round":{"humanPlayer":{"gesture":"scissors","name":"Human Player","score":3},
                        "computerPlayer":{"gesture":"paper","name":"Computer Player","score":0},
                        "roundWinner":{"gesture":"scissors","name":"Human Player","score":3}
               },
               "status":"IN_PROGRESS"},
               {"round":{"humanPlayer":{"gesture":"scissors","name":"Human Player","score":3},
                         "computerPlayer":{"gesture":"paper","name":"Computer Player","score":0},
                         "roundWinner":{"gesture":"scissors","name":"Human Player","score":3}
               },
               "status":"IN_PROGRESS"},
               {"round":{"humanPlayer":{"gesture":"scissors","name":"Human Player","score":3},
                         "computerPlayer":{"gesture":"paper","name":"Computer Player","score":0},
                         "roundWinner":{"gesture":"scissors","name":"Human Player","score":3}},
               "status":"GAME_OVER"
               }]
}
 
You can start the program by downloading the rockpaperscissors.jar in your local environment and run it in the terminal
following the command:
java -jar ./rockpaperscissors-1.0.jar
