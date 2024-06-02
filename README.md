# _Project Funder_

### Idea:
- Create an app that could help people's ideas & passions become actual projects.
- Let people browse a wide variety of brilliant projects, and maybe even sponsor said projects.

### Users:
| User type | Use cases |
| ------ | ------ |
| Creator | Create project |
|         | Set project funding goal |
|         | Set social goals & rewards |
|         | Send updates about project manufacturing & delivery |
| Sponsor | Pledge money to one or various projects |
|         | Select pledge "level" depending on interest |
|         | Participate in achieving secondary goals |
|         | Give suggestions/ideas to project creators |

### Implementation:
To be able to make this app we will need to first think of a suitable database that could contain all the data we want to be stored. We will create the following DB tables:
- User
- Project
- User_Project
- Pledge_Reward
- Social_Goal
- Social_Reward

Conceptual Database diagram:
![database diagram](https://raw.githubusercontent.com/alexFban/Project_Funding_App/main/DB_Diagram.png)
User:

    This table contains the necessary data for the user to log in, get notification/email and identify him as a creator or a sponsor.

Project:

    This table contains all the significant details about the project (how many money has been pledge, necessary money for the project to be produced).

User_Project:

    This is just a connection table, used for implementing a many-to-many relation between the users and the projects.

Pledge_Reward:

    This table contains the data about which type of rewards will be received by each user depending on how much money they've pledged.

Social Goal/Social Rewards:

    This tables contain data about some extra ways for the community to get more free rewards after the completion of the funding period.

There's been added an Observer-like logic to the users, so that they can get a notification/email whenever a project update is done. This includes any modification done to the projects, social goals/reward and pledge rewards.
The Observer is an interface with an update method that has an Object type parameter. This interface is implemented by User, Project and User_Project, everyone of these classes having a different approach to the methods implementation. All classes except the User class must send an Object to their respective observers, this way we create a chain of observers like these: User -> User_Project -> Project -> Social Goal and Pledge Reward (-> = observes).

### Endpoints:
1. User
    - POST (http://localhost:8080/api/users) : add a new user to the database.
    - GET/id (http://localhost:8080/api/users/{id}) : returns the user with the specified id.
    - GET (http://localhost:8080/api/users/{uId}/projects) : returns all projects sponsored by the user with the specified id.
    - GET (http://localhost:8080/api/users) : returns all the users in the DB.
    - PUT (http://localhost:8080/api/users/{id}) : updates the user with the specified id, modifying the given data.
    - DELETE (http://localhost:8080/api/users) : deletes the user with the specified id from the DB.
2. Project
    - POST (http://localhost:8080/api/projects) : add a new project to the database.
    - GET/id (http://localhost:8080/api/projects/{id}) : returns the project with the specified id.
    - GET (http://localhost:8080/api/projects/{uId}/users) : returns all users that sponsored the project with the specified id.
    - GET (http://localhost:8080/api/projects) : returns all the projects in the DB.
    - PUT (http://localhost:8080/api/projects/{id}) : updates the project with the specified id, modifying the given data.
    - DELETE (http://localhost:8080/api/projects) : deletes the project with the specified id from the DB.
3. User_Project
    - POST (http://localhost:8080/api/user_projects) : add a new user project relation to the database.
    - GET/id (http://localhost:8080/api/user_projects/{id}) : returns the user project relation with the specified id.
    - GET (http://localhost:8080/api/user_projects) : returns all the user project relations in the DB.
    - DELETE (http://localhost:8080/api/user_projects) : deletes the user project relation with the specified id from the DB.
4. Pledge_Reward
    - POST (http://localhost:8080/api/pledge_rewards) : add a new pledge reward to the database.
    - GET/id (http://localhost:8080/api/pledge_rewards/{id}) : returns the pledge reward with the specified id.
    - GET (http://localhost:8080/api/pledge_rewards) : returns all the pledge rewards in the DB.
    - PUT (http://localhost:8080/api/pledge_rewards/{id}) : updates the pledge reward with the specified id, modifying the given data.
    - DELETE (http://localhost:8080/api/pledge_rewards) : deletes the pledge reward with the specified id from the DB.
5. Social_Goal
    - POST (http://localhost:8080/api/social_goals) : add a new social goal to the database.
    - GET/id (http://localhost:8080/api/social_goals/{id}) : returns the social goal with the specified id.
    - GET (http://localhost:8080/api/social_goals) : returns all the social goals in the DB.
    - PUT (http://localhost:8080/api/social_goals/{id}) : updates the social goal with the specified id, modifying the given data.
    - DELETE (http://localhost:8080/api/social_goals) : deletes the social goal with the specified id from the DB.
6. Social_Reward
    - POST (http://localhost:8080/api/social_rewards) : add a new social reward to the database.
    - GET/id (http://localhost:8080/api/social_rewards/{id}) : returns the social reward with the specified id.
    - GET (http://localhost:8080/api/social_rewards) : returns all the social rewards in the DB.
    - PUT (http://localhost:8080/api/social_rewards/{id}) : updates the social reward with the specified id, modifying the given data.
    - DELETE (http://localhost:8080/api/social_rewards) : deletes the social reward with the specified id from the DB.

The backend functionallity is now 90% complete. All it's missing are some functionalities that will be determined when implementing the frontend.

The way that the backend is designed enables the user to access the data from all the different DB tables using CRUD operations, which should make the implementation of the frontend a lot easier and more straightforward.

###### Final Backend UML Diagram
This is an abstract representation of the way this app works. In each of the classes Data represents one of the following: User, User_Project, Project, Pledge_Reward, Social_Goal, Social_Reward. The basics are as follow: the Controller class communicates with the frontend (doesn't matter what kind, android, web, ...) and calls the neccessarry methods for each use case from the Service class. The Repository class is the one that communicates with the Database (kind of, it actually calls some methods from JpaRepository, which in return manages the database).
![uml diagram](https://raw.githubusercontent.com/alexFban/Project_Funding_App/main/UML_Diagram.PNG)

###### Final Use Case Diagram
The use cases are sadly less in number than anticipated, but it's still a good base for an app, and it could be easily expanded into what I had initially in mind.
![use case diagram](https://raw.githubusercontent.com/alexFban/Project_Funding_App/main/Use_Case_Diagram.PNG)