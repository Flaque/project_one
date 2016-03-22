# project_one
The first project of the semester for Object Oriented.

---

# On git.

## How to setup
1. Make sure the creator has added you as a collab.
2. Run `git clone https://github.com/Flaque/project_one.git`. This will create a folder for you wherever you ran the command,
so **be careful**.
3. Open Eclipse and when it asks you where you want to open your workspace, pick the folder that git created for you.

## How to make changes
1. Make a change(s).
2. Open up your cmd/terminal. Type `git status`.
3. You should see a bunch of file paths in red. This is okay.
  - These are all the files that have been added or changed.
  - In order to add these files, you will need to run `git add path/to/my/file.java` (for each file)
    - OR! if you just want to add everything, you can run `git add *`.
    - You can also add directories via `git add path/to/my/directory`
  - Once you've added everything, your changes that are "staged for commit" will turn green when you run `git status`
4. Now, you will need to "commit" your changes.
  - Commiting in git just means that this is a place that you can go back to if you would like to revert. It's just a dot
   on your git timeline.
  - To commit all your changes, you should run `git commmit -m "Say something about your changes here"`
  - At this point, if you run `git status`, it should not have all the things you commited in red or green.
5. Great! Let's push the changes to github.
  - First, we're going to need to run `git pull` before we can push. Someone might have changed something recently.
  - You might get a merge conflict if you haven't pushed or pulled in awhile. If that happens, skip to the section on **How to fix Merge Conflicts**
  - If all goes well, then you can run `git push` and your changes should be on github. If you're scared and want to make sure, you can go check github online to see!

## How to fix merge conflicts
1. Sometimes, when you pull, you'll get a message that you have lots of merge conflicts! OH NO! WHAT NOW?!
2. Don't panic, it's only slightly difficult and terrifying to deal with this.
3. Your message should give you a path or multiple pathes of which file has the conflicts.
4. Open up that file in your editor and do a command-f search for `>>>>` And you find something like the following:

`<<<<<<< HEAD`

    `//Some code here`

`=======`

   `//Some slightly different code here`

`>>>>>>> master`

5. Essentially what this is saying, is that you now have two options. You have the "HEAD" which is the **current version of the file on your computer** that you have modified. And then you have what's on the **master** branch. The master branch is what is currently on Github.
6. So, if I wanted the stuff in "HEAD" and not the stuff in master, I would edit the file so that it is now:


 `//Some code here`


 7. Literally the only thing I have done is remove all of the git stuff.
 8. You can then run `git commit -m "merged stuff"` and push. Then you're fine.


 ---

 

#Prototype plan: Overview

Hour logs aren't going to work easily for us since we're building a game. We don't completely know how long things are going to take or even what tasks we will need to do. A better strategy to divide up work and plan things is to hit a series of prototypes and stages. Basically we're going to do a mini agile methodology because waterfall doesn't work easily for us here.

## For educational purposes
Learn yee some vocab:

- **User Stories** - An incredibly pretentious word made up by CS hippies to describe a thing that needs done from the Users prospective.
  - _Example: "Jim should be able to jump"_

- **Tasks** - A thing that needs done, but from a developer prospective. Typically there are one or more associated with a _User Story_.
  - _Example: "Write a function to give an upward impulse to the player model when the keylistener hears an 'up' key."_

- **Sprint** - A period of time in which we get a lot of user stories done. It's basically saying, "We're going to try and get this done in a week or so, and then we're going to see if we actually did".

Great. Now put that shit on a resume because you know now the basics of Agile/Scrum.

#Our timeline

## Prototype 1 (Basics)

The super basics.

- Player character is on the screen.
- Player character can move via a user typing a key

## Prototype 2 (Camera)
- Add a block, or some other entity to the screen.
- When the player moves upwards, they actually stay on the same y-cord. The block moves down. THE WORLD MOVES AROUND YOU.

## Prototype 3 (Collision)

Playing with the Grid and Collision.
Note: We're creating a very specific map here. THIS IS NOT THE FULL MAP.

- Player can jump.
- The user sees two platforms. One below the player (That the player is standing on) and one above the player.
- The top level layer has a hole in it. (IE: There's a block missing in it)
- If the player jumps and hits a block, output something on the screen. (testing collision)
- The player can jump through the hole, and if it lands on the new platform, he can stand on that platform. (And don't output something on the screen.)

## Prototype 4 (Map Gen)

Playing with map generation

- The map generates automagically. Each platform has a hole in it.
- The user can jump through the hole and the map will generate more above him.

## Prototype 5 (Death and basic menus)
In which bad things happen

- Each time the player passes through a hole, increment a score value.
- If the player hits the block, a menu pops up that:
  - Lets the player reset
  - Show the score
- When the player hits the reset. Reset the game. Regenerate. Place the player again.

----

At this point, we've gotten a game. Woo. Now we can start making some superflous additions like menus and prettiness. At this point, we can start following a lot of our inital plans because we're basically back at developing an initial application. We don't need to pivot because our game sucks and we basically know how to make this stuff.

# Design Alternative Analysis

## Do we use a state machine?

In a game, especially a simple one like ours, we have can have the concept of 'state'. If we were to use a state machine, we would have three states: "Main Menu", "Game", and "Game over". If we keep track of this state, then we'll be able to easily switch between screens and be able to control threading when we change states. Each state machine would have its own view and controller. We would try and share as little information between the controllers as possible. We would implement a StateHandler that would pass information to and from the states. A state would only know it's handler, and nothing about the other states that it wasn't explicitly told by its handler.

However, our state machine is not pure. "Game over" and "Game" overlap by happening essentially at the same time. By our UI design and by the concepts that we had written down before, the Game Over menu hovers above the game where the player died. To handle this in a state machine, the renderer for the Game state would either have to be passed to the Game Over state or the Game Over state would have to pause the rendering thread of one state while implementing its own rendering thread. It gets incredibly messy quite fast.

But, if we don't use a state machine, we would need to put the Game Over inside of the class system of Game. We would have an odd side extension to our "Game" view. The Game's View is all of a sudden not doing simply rendering for the game, but now it's doing rendering for Game Over. This breaks our object oriented concepts by allowing GameView to know too much.

Another option we could try is to delegate out to two specific views controlled by a main view: GamingView and GameOverView. However, this is heavily over engineering for the moment. It forces the perfect to be the enemy of the good.

## How do we handle concurrency in sprite creation?

We've structured our objects so that everything extends from an abstract Entity class, which handles position, size, and collision. Then, some things, namely visible objects, extend Sprite (which in turn extends Entity). A Sprite is just an Entity with an image or an animation. However, a sprite makes things incredibly difficult when we load images. Loading an image in Java is the super ugly series of try and catch blocks that we'd like to abstract away from the end user of Sprite. However, a Sprite needs to be more or less initialized with an image and not Null. If it is null, then we might run into vastly more errors in the future.

One way we could solve this problem is to have an Image Baron. An Image Baron is a class that's called on startup that preloads in images and then allows them accessiblity via an array or public getter methods. With an image baron, creating a sprites fairly simple because no one has to create a sprite initalized with a Null image value. Images are assured before a sprite is ever created. It also catches problems with the project build before anything else. 

However an Image Baron in Java needs to only ever run once and needs to be more/less global. Both of these things are very hard to achieve in Java. If you want something to be Global in Java, you can make it static. However, then that object doesn't have any state and therefore can never run in the first place. You can get around this problem by creating a singular Baron object and then passing it around. However, this does not assure the singular nature of the Image Baron because someone could easily create a second Baron and then its point is ruined. It leaves the door wide open for software rot and bugs caused by misuse of the Baron. 

Another option is to do away with our current method of Sprite construction. Instead of extending a sprite, an object would have a sprite as a property that would be given to it. We could use the factory pattern to create our objects. However, this is extremely overkill for our little project. If we had thousands of various entities and objects, then this would be our only option, no doubt. However we will probably have less than 10. 

In the end, having a Sprite take in a null value for the image and then setting it later might be the best solution here. It leaves us open for a problem, but its problems might be less than that of the Image Baron or the difficulty of the factory method. 
