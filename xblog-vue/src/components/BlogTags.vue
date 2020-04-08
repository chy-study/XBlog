<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        label="标题"
        width="220"
        show-overflow-tooltip>
        <template slot-scope="scope">{{ scope.row.title }}</template>
      </el-table-column>
      <el-table-column
        label="作者"
        width="120">
        <template>{{ username }}</template>
      </el-table-column>
      <el-table-column
        label="更新时间"
        show-overflow-tooltip>
        <template slot-scope="scope">{{ scope.row.updateTime | formatDate}}</template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <br/>
    <el-pagination
      style="float: right"
      background
      layout="prev, pager, next"
      :page-size=pageSize
      :total=total
      @current-change="page">
    </el-pagination>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection()">批量删除</el-button>
    </div>

  </div>
</template>

<script>
  import {formatDate} from '../utils/date'
  export default {
    name: "BlogTags",
    filters: {
      formatDate(time) {
        var date = new Date(time);
        return formatDate(date, "yyyy-MM-dd hh:mm");
      }
    },
    data() {
      return {
        pageSize: 5,
        total: 0,
        tableData: [],
        username: "",
        multipleSelection: []
      }
    },

    methods: {
      toggleSelection(rows) {
        console.log(this.multipleSelection)
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      handleClick(row) {
        console.log(row);
      },
      page(currentPage){
        const _this = this;
        this.$axios.get('/blog?statu='+_this.statu+'&page='+currentPage+'&count='+5+'&keyword='+'').then(function (resp) {
          console.log(resp);
          _this.tableData = resp.data.blogs;
          _this.pageSize = resp.data.size;
          _this.username = resp.data.username;
          _this.total = resp.data.totalCount;
        })
      }
    },

    props: ['statu'],

    created() {
      const _this = this;
      this.$axios.get('/blog?statu='+_this.statu+'&page='+1+'&count='+5+'&keyword='+'').then(function (resp) {
        console.log(resp);
        _this.tableData = resp.data.blogs;
        _this.pageSize = resp.data.size;
        _this.username = resp.data.username;
        _this.total = resp.data.totalCount;
      })

    },

  }
</script>

<style scoped>

</style>
