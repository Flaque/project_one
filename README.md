# project_one
The first project of the semester for Object Oriented.

# How to setup
1. Make sure Evan added you as a collab.
2. Run `git clone https://github.com/Flaque/project_one.git`. This will create a folder for you wherever you ran the command,
so **be careful**. 
3. Open Eclipse and when it asks you where you want to open your workspace, pick the folder that git created for you. 

# How to make changes 
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
  
# How to fix merge conflicts
1. Sometimes, when you pull, you'll have a problem. //TODO 
  
  
  
