# FIX_STR Branch 
**to be pulled to smartReduce3 branch**
The Smart Test Reducer in the master and smartreduce3 branches is defunct.  Smart Test Reducer is being rewritten in this branch to target unnessesary initializations and remove them from the already reduced branch.  This branch is intended to be pulled to smartreduce3, and after tests check out, eventually pulled to master.

###Branch Checklist
- [ ] Change actions dependent on the (removed) re-initializations to those in the same family, with their poolvals the same as the previous action, except poolval[repId] = what index the (old) initialization action set
