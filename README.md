# FIX_STR Branch
The Smart Test Reducer in the master and smartreduce3 branches is defunct.  Smart Test Reducer is being rewritten in this branch to target unnessesary initializations and remove them from the already reduced branch.  This branch is intended to be pulled to smartreduce3, and after tests check out, eventually pulled to master.

###Branch Checklist
- [ ] Remove /build folder and the build jar
- [ ] Update .gitignore
- [ ] Remove/comment out code of defunct STR
- [ ] Remove family id's from the Action interface and ActionEntry
- [ ] Give each pool entry a unique id
- [ ] Add method initId() to Action - corrosponds to PoolEntry id, -1 for an action without initialization
- [ ] New smart test reducer will look for duplicate actions with the same initId() in a reduced test; will attempt to remove all but one
- [ ] Test New Smart Test reducer befor pulling changes
- [ ] Revert this file so the master readme remains unchanged
