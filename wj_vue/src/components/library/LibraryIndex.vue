<template>
    <div>
        <el-container>
            <el-aside style="width: 200px;margin-top: 20px">
                <switch></switch>
                <side-menu @indexSelect="listByCategory" ref="sideMenu"/>
            </el-aside>
            <el-main>
                <books class="books-area" ref="booksArea"></books>
            </el-main>
        </el-container>
    </div>
</template>

<script>
import SideMenu from './SideMenu'
import Books from './Books'

export default {
    name: 'Library',
    components: {
        SideMenu, Books
    },
    methods: {
        listByCategory() {
            var _this = this
            var cid = this.$refs.sideMenu.cid
            var url = '/categories/' + cid + '/books'
            this.$axios.get(url)
                .then(resp => {
                    if (resp && resp.status === 200) {
                        _this.$refs.booksArea.books = resp.data
                    }
                })
        }
    }
}
</script>

<style scoped>
    .books-area {
        width: 990px;
        margin-right: auto;
        margin-left: auto;
    }
</style>
