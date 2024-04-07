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

A more in depth diagram in found in the github repository.
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

There's been added an Observer-like logic to the users, so that they can get a notification/email whenever a project update is done. This includes any modification done to the projects social goals/reward and pledge rewards.