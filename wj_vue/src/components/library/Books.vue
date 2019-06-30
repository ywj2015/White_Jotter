<template>
    <div>
       <el-row style="height: 840px;">
           <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
           <view-switch class="switch"></view-switch>
           <el-tooltip effect="dark" placement="right" v-for="book in books.slice((currentPage - 1) * pagesize, currentPage * pagesize)" :key="book.id">
               <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{ book.title }}</p>
               <p slot="content" style="font-size: 13px;margin-bottom: 6px;">
                   <span>{{ book.author }}</span> /
                   <span>{{ book.date }}</span> /
                   <span>{{ book.press }}</span>
               </p>
               <p slot="content" style="width: 300px;" class="abstract">{{ book.abs }}</p>
               <el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;
                        margin-left: 15px;" class="book" body-style="padding: 10px;" shadow="hover">
                    <div class="cover" @click="editBook(book)">
                        <img :src="book.cover" alt="封面">
                    </div>
                    <div class="info">
                        <div class="title">
                            <a href="">{{ book.title }}</a>
                        </div>
                        <i class="el-icon-delete" @click="deleteBook(book.id)"></i>
                        <div class="author">{{ book.author }}</div>
                    </div>
               </el-card>
           </el-tooltip>
           <edit-form @onSubmit="loadBooks()" ref="edit"></edit-form>
       </el-row> 
       <el-row>
         <el-pagination :total="books.length" 
            :current-page="currentPage"
            :page-size="pagesize"
            @current-change="handleCurrentChange">

         </el-pagination>
       </el-row>
    </div>
</template>

<script>
import SearchBar from './SearchBar'
import EditForm from './EditForm'
import ViewSwitch from './ViewSwitch'

export default {
    name: 'Books',
    components: {
        SearchBar, EditForm, ViewSwitch
    },
    data() {
        return {
            books: [],  
            currentPage: 1,
            pagesize: 17
        }
    },
    mounted: function() {
        this.loadBooks()
    },
    methods: {
        loadBooks() {
            var _this = this
            this.$axios
                .get('/books')
                .then(resp => {
                    if (resp && resp.status === 200) {
                        _this.books = resp.data
                    }
                })
        },

        handleCurrentChange(currentPage) {
            this.currentPage = currentPage
            console.log(this.currentPage)
        },

        searchResult() {
            var _this = this
            this.$axios.post('/search', {
                keywords: this.$refs.searchBar.keywords
            }).then(resp => {
                if (resp && resp.status === 200) {
                    console.log(this.$refs.searchBar.keywords)
                    console.log(resp.data)
                    _this.books = resp.data
                }
            })
        },

        deleteBook(id) {
            this.$confirm('此操作将永久删除该书籍，是否继续', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$axios.post('/delete', {id: id})
                    .then(resp => {
                        if (resp && resp.status === 200) {
                            this.loadBooks()
                        }
                    })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                })
            });
        },

        editBook(book) {
            this.$refs.edit.dialogFormVisible = true
            this.$refs.edit.form = {
                id: book.id,
                cover: book.cover,
                title: book.title,
                author: book.author,
                date: book.date,
                press: book.press,
                abs: book.abs,
                cid: book.cid
            }
        }
    }
}
</script>

<style scoped>
    .cover {
        width: 115px;
        height: 172px;
        margin-bottom: 7px;
        overflow: hidden;
        cursor: pointer;
    }
    img {
        width: 115px;
        height: 172px;
    }
    .title {
        font-size: 14px;
        text-align: left;
    }
    .author {
        color: #333;
        width: 102px;
        font-size: 13px;
        margin-bottom: 6px;
        text-align: left;
    }
    .abstract {
        display: block;
        line-height: 20px;
    }

    .el-icon-delete {
        float: right;
        cursor: pointer;
    }

    .switch {
        display: flex;
        position: absolute;
        left: 780px;
        top: 6px;
    }

    a {
        text-decoration: none;
    }

    a:link, a:visited, a:focus {
        color: #3377aa;
    }
</style>
