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
