import { createVote, showVoteList } from "@/api/community.js";

const communityStore = {
  namespaced: true,
  state: {
    vote_list: [],
    select: 0,
    acount: 0,
    bcount: 0,
    vote_detail: [],
    lastVoteId: 0,
    last: false,
  },

  getters: {},

  mutations: {
    SET_VOTE_LIST: (state, vote_list) => {
      for (var vote of vote_list.content) {
        state.vote_list.push(vote);
      }
      state.lastVoteId =
        vote_list.content[vote_list.numberOfElements - 1].voteId;
      state.last = vote_list.last;
    },
    SET_SELECT: (state, select) => {
      state.select = select;
    },
    SET_COUNT: (state, acount, bcount) => {
      state.acount = acount;
      state.bcount = bcount;
    },
    SET_VOTE_DETAIL: (state, vote_detail) => {
      state.vote_detail = vote_detail;
    },
    SET_INIT(state) {
      state.vote_list = [];
    },
  },

  actions: {
    REGIST_VOTE: ({ commit }, { info, token }) => {
      console.log("info: ", info);
      console.log("token: ", token);

      return createVote(token, info, ({ data }) => {
        commit;
        data;
      });
    },
    SHOW_VOTE_LIST: ({ commit }, { params }) => {
      params;
      return showVoteList(params, ({ data }) => {
        commit("SET_VOTE_LIST", data);
      });
    },
  },
};

export default communityStore;
