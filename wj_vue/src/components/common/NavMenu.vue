<template>
    <div>
        <el-menu
            :default-active="$route.path"
            router
            mode="horizontal"
            background-color="white"
            text-color="#222"
            active-text-color="red"
            style="min-width: 1300px">
            <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
                {{ item.navItem }}
            </el-menu-item>
            <a href="/more" style="color: #222;float: right;padding: 20px;">更多功能</a>
            <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>
            <span style="position: absolute;margin-top: 10px;padding-top: 10px;right: 43%;font-size: 20px;font-weight: bold">White Jotter - Your Mind Palace</span>
            <el-input
                placeholder="快速搜索"
                prefix-icon="el-icon-search"
                size="medium"
                style="width: 300px;position:absolute;margin-top: 12px;right: 18%"
                v-model="keywords">
            </el-input>
        </el-menu>
    </div>
</template>

<script>
export default {
    name: 'NavMenu',
    data() {
        return {
            navList: [
                {name: '/index', navItem: '首页'},
                {name: '/jotter', navItem: '笔记本'},
                {name: '/library', navItem: '图书馆'},
                {name: '/admin', navItem: '个人中心'}
            ],
            keywords: ''
        }
    },
}
</script>

<style scoped>
    a {
        text-decoration: none;
    }
    span {
        pointer-events: none;
        user-select: none;
    }
</style>
